
public class gaAlg {

	private static int lengthOfChr=8;
	private static int[] gaDataArray={0,1};
	
	public static NodeChr[] currentChrArray;
	public NodeChr[] nextChrArray;

	
	public static void createRandomGeneration(int numOfChr)
	{
		currentChrArray=new NodeChr[numOfChr];
		for(int i=0;i<numOfChr;i++)
		{
			NodeChr tmpGa=createRandomChr();
			currentChrArray[i]=tmpGa;
		}
	}
	private static NodeChr createRandomChr()
	{
		int[] gaArray=new int[lengthOfChr];
		for(int i=0;i<lengthOfChr;i++)
		{
			gaArray[i]=gaDataArray[(int) (Math.random()*10)%2];
		}
		NodeChr output = null;
		output.setChr(gaArray);
		return output;
	}
	
	
	public static void main(String[] arg)
	{
		createRandomGeneration(4);
		for(int i=0;i<4;i++)
		{
			System.out.print(currentChrArray[i].toString());
		}
			
	}
}
