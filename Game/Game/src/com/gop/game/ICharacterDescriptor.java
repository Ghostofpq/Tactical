package com.gop.game;

public interface ICharacterDescriptor {
	
	public String getNameForDisplay();
	public String getRaceForDisplay();
	public String getGenderForDisplay();
	
	public String getHPForDisplay();
	public String getMPForDisplay();	

	public String getLevelForDisplay();
	public String getCurrentXpForDisplay();
	public String getXpNextLvl();
	
	public String getPathForPortrait();
	
	public String getStrenghtForDisplay();
	public String getEnduranceForDisplay();
	public String getIntelligenceForDisplay();
	public String getWillForDisplay();
	public String getAgilityForDisplay();
	public String getMovementForDisplay();	

	public String getCurrentJobForDisplay();
	public String getCurrentJobJobPointsForDisplay();
}
