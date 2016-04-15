
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
	
	public static void countAdapterFunction()
	{
		for(int i=0;i<currentChrArray.length;i++)
		{
			int[] chrData=currentChrArray[i].getChr();
			
			int toNum=0;
			for(int j=0;j<chrData.length;j++)//二進轉十進
			{
				toNum+= chrData[j]*Math.pow(2, (7-j));
			}
			
			int adapter=equation(toNum);//引入方程式
			//System.out.print(toNum+"\n");
			//System.out.print(adapter+"\n");
			
			currentChrArray[i].setAdapter(adapter);//存進Node
		}
	}
	
	public static int equation(int x)//方程式
	{
		/*
		 * countAdapterFunction的副程式
		 * 
		 * 計算一元二次方程式
		 * x為輸入值
		 * c為輸出值
		 *  x^2-5x+6
		 *  
		 */
		int c=0;
		c=(int) Math.pow(x, 2)-5*x+6;
		
		return c;
	}
	public static void main(String[] arg)
	{
		createRandomGeneration(4);
		for(int i=0;i<4;i++)
		{
			System.out.print(currentChrArray[i].toString()+"\n");
		}
		
		countAdapterFunction();
	}
}
