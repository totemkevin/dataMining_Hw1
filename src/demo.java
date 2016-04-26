
public class demo {

	
	public static void main(String[] arg)
	{
		int num=2;
		gaAlg.createRandomGeneration(num);
		for(int i=0;i<num;i++)
		{
			System.out.print(i+" : "+gaAlg.currentChrArray[i].toString()+"\n");
		}
		gaAlg.setInputNum(8);
		int c=0;
		boolean endBool=false;
		
		do{
			gaAlg.adapterFunction();
			gaAlg.Selection();
			
			
			System.out.print("=====================selected\n");
			for(int i=0;i<gaAlg.selectedChrArray.length;i++)
			{
				System.out.print(i+" : "+gaAlg.selectedChrArray[i].toString()+"\n");
			}
			
			
			System.out.print("=====================nextChrArray\n");
			gaAlg.exchange();
			for(int i=0;i<gaAlg.nextChrArray.length;i++)
			{
				System.out.print(i+" : "+gaAlg.nextChrArray[i].toString()+"\n");
			}
			endBool=gaAlg.endRule();
			//System.out.print("ans : "++"\n");
			System.out.print("ans : "+gaAlg.ans+"\n");
			
			gaAlg.min();
			System.out.print("min : "+gaAlg.min);
			
			c++;
		}while(c<3 & !endBool);
		
		
	}
}
