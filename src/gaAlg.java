
public class gaAlg {

	private static int lengthOfChr=8;
	private static int[] gaDataArray={0,1};
	
	public static NodeChr[] currentChrArray;
	public NodeChr[] nextChrArray;

	
	public static void createRandomGeneration(int numOfChr)
	{
		/*
		 * 主要Function
		 * 產生隨機的子代
		 * numOfChr = 這一代中染色體各數
		 */
		currentChrArray=new NodeChr[numOfChr];
		for(int i=0;i<numOfChr;i++)
		{
			NodeChr tmpGa=createRandomChr();
			currentChrArray[i]=tmpGa;
		}
	}
	private static NodeChr createRandomChr()
	{
		/*
		 * createRandomGeneration的副程式
		 * 產生隨機的染色體
		 */
		int[] gaArray=new int[lengthOfChr];
		for(int i=0;i<lengthOfChr;i++)
		{
			gaArray[i]=gaDataArray[(int) (Math.random()*10)%2];
		}
		NodeChr output=new NodeChr();
		output.setChr(gaArray);
		return output;
	}
	
	
	/*public static void main(String[] arg)
	{
		createRandomGeneration(4);
		for(int i=0;i<4;i++)
		{
			System.out.print(currentChrArray[i].toString()+"\n");
		}
			
	}*/
}
