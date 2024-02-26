#version 410

uniform vec3 u_colour; // colour as a 3D vector (R, G, B)

layout(location = 0) out vec4 o_colour; // (R, G, B, A)

void main() {
	o_colour = vec4(u_colour, 1);
}