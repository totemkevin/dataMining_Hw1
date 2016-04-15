
public class gaAlg {

	private static int lengthOfChr=8;
	private static int[] gaDataArray={0,1};
	
	public static NodeChr[] currentChrArray;
	public NodeChr[] nextChrArray;

	
	public static void createRandomGeneration(int numOfChr)
	{
		/*
		 * �D�nFunction
		 * �����H�����l�N
		 * numOfChr = �o�@�N���V����U��
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
		 * createRandomGeneration���Ƶ{��
		 * �����H�����V����
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
			for(int j=0;j<chrData.length;j++)//�G�i��Q�i
			{
				toNum+= chrData[j]*Math.pow(2, (7-j));
			}
			
			int adapter=equation(toNum);//�ޤJ��{��
			//System.out.print(toNum+"\n");
			//System.out.print(adapter+"\n");
			
			currentChrArray[i].setAdapter(adapter);//�s�iNode
		}
	}
	
	public static int equation(int x)//��{��
	{
		/*
		 * countAdapterFunction���Ƶ{��
		 * 
		 * �p��@���G����{��
		 * x����J��
		 * c����X��
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
