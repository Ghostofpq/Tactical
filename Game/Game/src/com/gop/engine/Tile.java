package com.gop.engine;

import lombok.Getter;
import lombok.Setter;

import org.newdawn.slick.opengl.Texture;

import com.gop.engine.character.Character;
import com.gop.graphics.TileTexture;

@Getter
@Setter
public class Tile {

	public enum tileType {
		Walkable, Uncrossable, DifficultGround
	}

	public enum decorationType {
		None, Flowers1, Flowers2, Flowers3, Tree1
	}

	private int posX;
	private int posY;
	private int height;

	private boolean isHighlighted;
	private boolean isHighlightedGreen;
	private boolean isHighlightedRed;
	
	private TextureType texture;
	private tileType type;
	private decorationType decoration;

	private Texture textureTop;
	private Texture textureSO;
	private Texture textureNO;
	private Texture textureNE;
	private Texture textureSE;

	private Character character;

	private int deploymentZone;

	// CREATORS
	public Tile() {
		this.setPosX(0);
		this.setPosY(0);
		this.setHeight(3);
		this.setTexture(TextureType.GRASS_TEXTURE);
		this.setType(tileType.Walkable);
		this.setDecoration(decorationType.None);
		this.setHighlighted(false);
		this.setHighlightedGreen(false);
		this.setHighlightedRed(false);
		this.setDeploymentZone(0);
		this.setCharacter(null);
	}

	public Tile(int posX, int posY, int height) {
		this.setPosX(posX);
		this.setPosY(posY);
		this.setHeight(height);
		this.setTexture(TextureType.GRASS_TEXTURE);
		this.setType(tileType.Walkable);
		this.setDecoration(decorationType.None);
		this.setHighlighted(false);
		this.setHighlightedGreen(false);
		this.setHighlightedRed(false);
		this.setDeploymentZone(0);
	}

	public Tile(int posX, int posY, int height, int heightTotal,
			TextureType texture, tileType type, decorationType decoration) {
		this.setPosX(posX);
		this.setPosY(posY);
		this.setHeight(height);
		this.setTexture(texture);
		this.setType(type);
		this.setDecoration(decoration);
		this.setHighlighted(false);
		this.setHighlightedGreen(false);
		this.setHighlightedRed(false);
		this.setDeploymentZone(0);
	}

	public Tile(String XMLString) {
		int posX;
		int posY;
		int height;
		TextureType texture;
		tileType type;
		decorationType decoration;
		int inDeployementZone;

		posX = Integer.parseInt(GetXMLElement(XMLString, "X"));
		posY = Integer.parseInt(GetXMLElement(XMLString, "Y"));
		height = Integer.parseInt(GetXMLElement(XMLString, "Z"));
		texture = TextureType.valueOf((GetXMLElement(XMLString, "Tx")));
		type = tileType.valueOf((GetXMLElement(XMLString, "Ty")));
		decoration = decorationType.valueOf((GetXMLElement(XMLString, "Dc")));
		inDeployementZone = Integer.parseInt(GetXMLElement(XMLString, "DZ"));

		this.setPosX(posX);
		this.setPosY(posY);
		this.setHeight(height);
		this.setTexture(texture);
		this.setType(type);
		this.setDecoration(decoration);
		this.setHighlighted(false);
		this.setHighlightedGreen(false);
		this.setHighlightedRed(false);
		this.setDeploymentZone(inDeployementZone);
	}

	public void BindTextures(TileTexture tileTexture) {
		Texture[] textures = tileTexture.getBundle(this.getTexture());
		this.setTextureTop(textures[0]);
		this.setTextureSE(textures[1]);
		this.setTextureSO(textures[2]);
		this.setTextureNO(textures[3]);
		this.setTextureNE(textures[4]);
	}

	private String GetXMLElement(String XMLString, String balise) {
		int len = ("<" + balise + ">").length();
		int posDeb = XMLString.indexOf("<" + balise + ">");
		int posFin = XMLString.indexOf("</" + balise + ">");

		return XMLString.substring(posDeb + len, posFin);
	}

	public String toXMLString() {
		String s = new String();
		s = "";

		s += "<X>";
		s += this.getPosX();
		s += "</X>";

		s += "<Y>";
		s += this.getPosY();
		s += "</Y>";

		s += "<Z>";
		s += this.getHeight();
		s += "</Z>";

		s += "<Tx>";
		s += this.getTexture();
		s += "</Tx>";

		s += "<Ty>";
		s += this.getType();
		s += "</Ty>";

		s += "<Dc>";
		s += this.getDecoration();
		s += "</Dc>";

		s += "<DZ>";
		s += this.getDeploymentZone();
		s += "</DZ>";

		return s;
	}
}
