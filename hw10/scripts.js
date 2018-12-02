var scene, renderer, camera, controls;
var mouse = { x: 0, y: 0 };
var keyboard = new THREEx.KeyboardState();
cube_counter = 0;
sphere_flag = true;
sphere_counter = 0;

window.onload = function () {
	renderer = new THREE.WebGLRenderer( { antialias: true } );
	renderer.setClearColor( new THREE.Color ("lightgrey"))
	renderer.setSize( window.innerWidth, window.innerHeight );
	document.getElementById('theContainer').appendChild(renderer.domElement);

	scene = new THREE.Scene();

	camera = new THREE.PerspectiveCamera( 60, window.innerWidth / window.innerHeight, 1, 1000 );
	camera.position.set(0, 0, 15); 
	scene.add(camera);

	controls = new THREE.OrbitControls( camera, renderer.domElement );
	controls.addEventListener( 'change', render );

	lights = new Lights();

	makeSceneGraph()

	render()
	animate()
}

function animate() { 
	requestAnimationFrame( animate ); 
	update();
	render();
	text_updater();
	controls.update();
}

function text_updater() {
	var fieldNameElement = document.getElementById("info");
	fieldNameElement.textContent = "The number of enemy ships is: " + (cube_counter + sphere_counter) +
									". There are " + cube_counter + " boats and " + sphere_counter + " planes.";
}


function update()
{
	if ( keyboard.pressed("w") ) 
	{
		for(var i = 0; i < cube_counter; i++) {
			var cube_name = "cube" + i;
			var cube = scene.getObjectByName( cube_name );
			cube.material.color.setHex(0x9999ff);
			cube.position.set(i*2, i*2, i*2);
		}
	}
	else if(keyboard.pressed("s"))
	{
		for(var i = 0; i < cube_counter; i++) {
			var cube_name = "cube" + i;
			var cube = scene.getObjectByName( cube_name );
			cube.material.color.setHex(0x000088);
			cube.position.set(i, i, i);
		}
	}
	else if(keyboard.pressed("c"))
	{
		var cubeGeometry = new THREE.CubeGeometry( 1, 1, 1 );
		var cubeMaterial = new THREE.MeshBasicMaterial( { color: 0x000088 } );
		var cube = new THREE.Mesh( cubeGeometry, cubeMaterial );
		cube.name = "cube" + cube_counter;
		cube.position.set(cube_counter, cube_counter, cube_counter);
		scene.add(cube);
		cube_counter++;
	}
	else if(keyboard.pressed("v"))
	{
		if(cube_counter > 0) {
			var cube_name = "cube" + cube_counter;
			var cube = scene.getObjectByName(cube_name);
			scene.remove(cube);
			cube_counter--;
		}
	}
	else if(keyboard.pressed("p"))
	{
		var sphereGeometry = new THREE.SphereGeometry(1);
		var sphereMaterial = new THREE.MeshBasicMaterial( { color: 0x864212 } );
		sphere = new THREE.Mesh( sphereGeometry, sphereMaterial );
		sphere.position.set(1+sphere_counter, sphere_counter*2, -2);
		scene.add(sphere);
		sphere.name = "sphere" + sphere_counter;
		sphere_counter++;
	}
	else if(keyboard.pressed("l"))
	{
		if(sphere_counter > 0) {
			var sphere_name = "sphere" + sphere_counter;
			var sphere = scene.getObjectByName(sphere_name);
			scene.remove(sphere);
			sphere_counter--;
		} 
	}

	for(var i = 0; i < sphere_counter; i++) {
		var position = new THREE.Vector3();
		var sphere_name = "sphere" + i;
		var sphere = scene.getObjectByName(sphere_name);
		position.setFromMatrixPosition(sphere.matrixWorld);
		if(position.x >= 15) {
			sphere_flag = false;
		}
		else if(position.x <= -15) {
			sphere_flag = true;
		}
		if(sphere_flag) {
			sphere.translateX(0.1);
		}
		else {
			sphere.translateX(-0.1);
		}
	}

	
	controls.update();
}


function render() {
	renderer.render( scene, camera );
}


function makeSceneGraph () { 
	for(var i = 0; i < 5; i++) {
		var cubeGeometry = new THREE.CubeGeometry( 1, 1, 1 );
		var cubeMaterial = new THREE.MeshBasicMaterial( { color: 0x000088 } );
		var cube = new THREE.Mesh( cubeGeometry, cubeMaterial );
		cube.name = "cube" + cube_counter;
		cube.position.set(i,i,i);
		scene.add(cube);
		cube_counter++;
	}

	var skyBoxGeometry = new THREE.CubeGeometry( 10000, 10000, 10000 );
	var skyBoxMaterial = new THREE.MeshBasicMaterial( { color: 0x9999ff, side: THREE.BackSide } );
	var skyBox = new THREE.Mesh( skyBoxGeometry, skyBoxMaterial );
	scene.add(skyBox);

	for(var i = 0; i < 5; i++) {
		var sphereGeometry = new THREE.SphereGeometry(1);
		var sphereMaterial = new THREE.MeshBasicMaterial( { color: 0x864212 } );
		sphere = new THREE.Mesh( sphereGeometry, sphereMaterial );
		sphere.position.set(1+i, i*2, -2);
		scene.add(sphere);
		sphere.name = "sphere" + sphere_counter;
		sphere_counter++;
	}

	var pyramid = new Pyramid (new THREE.MeshPhongMaterial ({
		color: "green", shininess: 60 }))
	pyramid.position.set (0, 0, -6)
	pyramid.rotation.set (0, 45 * Math.PI/180, 0)
	scene.add(pyramid)
}

class Pyramid extends THREE.Object3D {
    constructor (material) {
	super ()
	var bot = new THREE.Mesh (
		new THREE.BoxGeometry (3, 3, 3),
		material)
	bot.position.set (0, -3/2, 0)
	this.add (bot)
	var mid = new THREE.Mesh (
		new THREE.BoxGeometry (2, 2, 2),
		material)
	mid.position.set (0, 2/2, 0)
	this.add (mid)
	var top = new THREE.Mesh (
		new THREE.BoxGeometry (1, 1, 1),
		material)
	top.position.set (0, 2 + 1/2, 0)
	this.add(top)
    }
}

class Lights {
    constructor () {
		this.mainLight = new THREE.DirectionalLight ("white", 1);
		this.mainLight.position.set (1, 0.5, 1);
		scene.add (this.mainLight);
		this.fillLight = new THREE.DirectionalLight ("white", 0.5);
		this.fillLight.position.set (-1, 0, 1 );
		scene.add (this.fillLight);
		this.ambientLight = new THREE.AmbientLight (0x404040);
		scene.add (this.ambientLight);
    }

    pressed (state, light) {
		light.visible = state
		render ()
    }
}