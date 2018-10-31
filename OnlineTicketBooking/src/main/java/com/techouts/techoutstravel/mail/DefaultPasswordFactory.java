package com.techouts.techoutstravel.mail;

import java.security.SecureRandom;
import java.util.Random;

public class DefaultPasswordFactory {
	private static final Random RANDOM = new SecureRandom();
	  public static final int PASSWORD_LENGTH = 8;
	  static StringBuilder pw;
	  public static StringBuilder generateRandomPassword()
	  {
		  String letters = "abcdefghjkmnpqrstuvwxyzABCDEFGHJKMNPQRSTUVWXYZ23456789+@";
	      pw = new StringBuilder();
	      for (int i=0; i<PASSWORD_LENGTH; i++)
	      {
	          int index = (int)(RANDOM.nextDouble()*letters.length());
	          pw.append(letters.substring(index, index+1));
	      }
	      return pw;
	  }
	  public static StringBuilder getPw(){
		  return pw;
	  }
}
