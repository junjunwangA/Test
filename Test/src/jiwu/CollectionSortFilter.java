package jiwu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CollectionSortFilter {

	public String[] filterFunction(String[] collection,String[] filterInfo){
		List<String> list = new ArrayList<String>();
		//judge exception
		if(collection==null||collection.length<=0){
			return null;
		}
		if(filterInfo==null||filterInfo.length<=0||filterInfo.length>4){// filter info is wrong 
			return null;
		}
		//storage
		String[][] tmpColl= new String[collection.length][4];
		for(int i =0;i<collection.length;i++){
			String[] tmp = collection[i].split("-");
			if(tmp==null||tmp.length!=4){//the song format is wrong , skip
				continue;
			}
			for(int j =0;j<4;j++){
				tmpColl[i][j]=tmp[j];
			}
		}
		//extract filter info and storage
		String [] index = new String[4];
		for(int i =0 ;i<filterInfo.length;i++){
			String[] tmp = filterInfo[i].split("=");
			if(!filterInfo[i].contains("=")){
				return null ; //filter info is error
			}
			if(tmp==null||tmp.length!=2){//the filter format is wrong , skip
				continue;
			}
			switch(tmp[0]){
			  case "genre" :
				  index[0]=tmp[1];
				  break;
			  case "artist":
				  index[1]=tmp[1];
				  break;
			  case "album":
				  index[2]=tmp[1];
				  break;
			  case "song":
				  index[3]=tmp[1];
				  break;
			  default:
				  return null;
			}
		}
		//access and judge
		for(int i =0;i<collection.length;i++){
			boolean flag = false;
			for(int j =0;j<index.length;j++){
				if(index[j]==null)continue;
//				System.out.println(index[j]+" "+ tmpColl[i][j]);
				if(index[j].equals(tmpColl[i][j])){
					flag=true;
				}else{
					flag=false;
				}
			}
			if(flag){
				list.add(collection[i]);
			}
		}
		return (String[]) list.toArray(new String[list.size()]);
	}
	public static void main(String[] args) {
		// 
//		input:{"rock-led zeppelin-ii-lemon song","metal-iron maiden-powerslave-aces high","pop-supremes-more hits-ask any girl","rock-faith no more-angel dust-rv","rock-van halen-ii-spanish fly"}
//	    filter: {"genre=rock","album=ii"}	
//	    output:{"rock-led zeppelin-ii-lemon song","rock-van halen-ii-spanish fly"}
	    
		String[] collection= {"dsfadf","rock-led zeppelin-ii-lemon song","metal-iron maiden-powerslave-aces high","pop-supremes-more hits-ask any girl","rock-faith no more-angel dust-rv","rock-van halen-ii-spanish fly"};

		String[] filterInfo = {"genre=rock","album=ii"};
		CollectionSortFilter co=new CollectionSortFilter();
		
		System.out.println(Arrays.toString(co.filterFunction(collection,filterInfo)));
	}

}
