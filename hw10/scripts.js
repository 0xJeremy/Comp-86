var scene, renderer, camera, controls;
var mouse = { x: 0, y: 0 };
var keyboard = new THREEx.KeyboardState();
cube_counter = 0;
sphere_flag = true;

window.onload = function () {
	renderer = new THREE.WebGLRenderer( { antialias: true } );
	renderer.setClearColor( new THREE.Color ("lightgrey"))
	renderer.setSize( window.innerWidth, window.innerHeight );
	document.getElementById('theContainer').appendChild(renderer.domElement);

	scene = new THREE.Scene();

	camera = new THREE.PerspectiveCamera( 60, window.innerWidth / window.innerHeight, 1, 1000 );
	camera.position.set(0, 0, 5); 
	scene.add(camera);

	controls = new THREE.OrbitControls( camera, renderer.domElement );
	controls.addEventListener( 'change', render );

	makeSceneGraph()

	render()
	animate()
}

function animate() { 
	requestAnimationFrame( animate ); 
	update();
	controls.update();
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

	var position = new THREE.Vector3();
	position.setFromMatrixPosition(sphere.matrixWorld);
	if(position.x >= 10) {
		sphere_flag = false;
	}
	else if(position.x <= -10) {
		sphere_flag = true;
	}
	if(sphere_flag) {
		sphere.translateX(0.1);
	}
	else {
		sphere.translateX(-0.1);
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

	var sphereGeometry = new THREE.SphereGeometry(1);
	var sphereMaterial = new THREE.MeshBasicMaterial( { color: 0x562212 } );
	sphere = new THREE.Mesh( sphereGeometry, sphereMaterial );
	scene.add(sphere);
}