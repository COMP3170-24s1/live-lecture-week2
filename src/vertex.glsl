#version 410

in vec4 a_position; // vertex position (X,Y,Z,W)

void main() {
	gl_Position = a_position;
}