
//TC gettoken() at the worst case O(m*n) removetokenO(1)
//SC no of cars parked in all the floors+no of all levels roughly nooflevels*noofspotsperfloor at the worst case
import java.util.*;
public class Parking {
int levels=0;
int spotsperlevel=0;
List<HashSet<Integer>> a;
Parking(int levels,int spotsperlevel)
{
	this.levels=levels;
	this.spotsperlevel=levels;
	a=new ArrayList<HashSet<Integer>>();
	for(int i=0;i<this.levels;i++) {
	a.add(new HashSet<Integer>());
	}
}
public String gettoken() {
	for(int i=0;i<this.levels;i++) {
	HashSet<Integer> current=a.get(i);
	if(current.size()==0) {
		current.add(0);
	}
	else {
		int temp=1;
		while(current.size()<spotsperlevel) {
			if(!current.contains(temp)) {
				current.add(temp);
				return String.valueOf(levels)+"!"+String.valueOf(temp);
			}
			temp++;
		}
	}
	}
	return "Full";
}
public void removetoken(String tokenno) {
	String[] arr=tokenno.split("!");
	int level=Integer.valueOf(arr[0]);
	int no=Integer.valueOf(arr[1]);
	a.get(level).remove(no);
}

}

