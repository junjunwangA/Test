package jiwu;

import java.util.Arrays;

/**
 * feature: convert a string of hexadecimal format to binary of memory
 * remark:pBuffer new memory should be given by caller
 * input: szHexTest: eg: "6566"
 * output: dataOutput: binary format of BUffer value:{0x65,0x66}}
 * return: the array of bytes 
 * @author junjwang
 *
 */
public class HexToBin {

	public static int[] hexToBin(String szHexText){
		int result[] ;
		if(szHexText==null||szHexText.equals("")){
			return null;
		}
		
		char[] hexChars= szHexText.toUpperCase().toCharArray();
		byte[] byteStr= new byte[hexChars.length/2];
	    result = new int[hexChars.length/2];
	    for (int i = 0; i < byteStr.length; i++) {  
	        int pos=i*2;
	        
	        byteStr[i]=(byte)(charToByte(hexChars[pos])<<4|charToByte(hexChars[pos+1]));
//	        System.out.println("µÚi¸ö×Ö½Ú"+byteStr[i]);
	        result[i]= byteStr[i];
	    }
		return result;
	}
	public static byte charToByte(char ch){
		return (byte)"0123456789ABCDEF".indexOf(ch);//get the mapping int value of 0x
	}
	public void testCase01(){
		int[] expectedBuffer={0x65,0x66};
		//import JUnit library
//		assertTrue(Arrays.equals(HexToBin.hexToBin("6566"), expectedBuffer));
	}
	public static void main(String[] args) {
		
		int result[] = hexToBin("6566");
		for(int i =0 ; i<result.length;i++){
			System.out.println(result[i]+"  ");
		}
		
		int[] expectedBuffer={0x65,0x66};
		for(int i= 0;i<2;i++){
			System.out.println("expectedBuffer i   "+expectedBuffer[i]);
		}
		

	}

}
