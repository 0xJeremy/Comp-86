class enemy {
	constructor(type, x, y) {
		this.speedx = 5;
		this.speedy = 5;
		this.posx = x;
		this.posy = y;
		this.vehicle = type;
		this.flag = true;
	}

	draw() {
		var canvas = document.getElementById("myCanvas");
		var c = canvas.getContext("2d");
		if(this.vehicle == "plane") {
			c.fillStyle = "blue";
			c.fillRect(this.posx, this.posy, this.posx+25, this.posy+25);
		}
		else if(this.vehicle == "boat") {
			c.fillStyle = "orange";
			c.fillRect(this.posx, this.posy, this.posx+25, this.posy+25);
		}
	}

	update() {
		if(this.flag) {
			this.posx = this.posx + this.speedx;
			this.posy = this.posy + this.speedy;
		}
		else {
			this.posx = this.posx - this.speedx;
			this.posy = this.posy - this.speedy;
		}
		if(this.posx + 25 > window.innerWidth*0.95
			|| this.posy + 25 > window.innerHeight*0.9) {
			this.flag = false;
		}
		if(this.posx < 0 || this.posy < 0) {
			this.flag = true;
		}
	}

}

function add_plane() {
	enemies.push(new enemy("plane", enemies.length*5, enemies.length*5));
	draw();
}
function add_boat() {
	enemies.push(new enemy("boat", enemies.length*5, enemies.length*5));
	draw();
}

function fire() {
	enemies.pop();
	draw();
}
function freeze() {
	move_flag = !move_flag;
}

function nuke() {
	enemies = []
	draw();
}

function draw() {
	var canvas = document.getElementById("myCanvas");
	var c = canvas.getContext("2d");
	canvas.width = window.innerWidth*0.95;
	canvas.height = window.innerHeight*0.90;
	c.fillStyle = "gray";
	c.fillRect(0, 0, canvas.width, canvas.height);
	for(i = 0; i < enemies.length; i++) {
		enemies[i].draw();
	}
}

var enemies = [];
draw();
var move_flag = true;

function animate() {
	if(move_flag) {
		for(i = 0; i < enemies.length; i++) {
		enemies[i].update();
		}
	}
	draw();
	window.requestAnimationFrame(animate);
}

window.requestAnimationFrame(animate);