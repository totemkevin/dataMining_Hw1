
public class demo {

	
	public static void main(String[] arg)
	{
		int num=8;
		gaAlg.createRandomGeneration(num);
		for(int i=0;i<num;i++)
		{
			System.out.print(i+" : "+gaAlg.currentChrArray[i].toString()+"\n");
		}
		
		gaAlg.adapterFunction();
		gaAlg.Selection();
		
		
		System.out.print("=====================\n");
		for(int i=0;i<num;i++)
		{
			System.out.print(i+" : "+gaAlg.selectedChrArray[i].toString()+"\n");
		}
		
		
		System.out.print("=====================\n");
		gaAlg.exchange();
		for(int i=0;i<num*num;i++)
		{
			System.out.print(i+" : "+gaAlg.nextChrArray[i].toString()+"\n");
		}
		
		System.out.print("ans : "+gaAlg.endRule()+"\n");
		System.out.print("ans : "+gaAlg.ansArray[0]+" "+gaAlg.ansArray[1]+"\n");
		
		gaAlg.min();
		System.out.print("min : "+gaAlg.minArray[0]+" "+gaAlg.minArray[1]);
		
	}
}
