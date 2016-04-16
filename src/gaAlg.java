
public class gaAlg {

	private static int lengthOfChr=8;
	private static int[] gaDataArray={0,1};
	
	public static NodeChr[] currentChrArray;	
	public NodeChr[] greatChrArray;
	public static NodeChr[] selectedChrArray;

	
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
	
	public static void adapterFunction()
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
	
	public static void Selection()//選出優秀基因
	{
		int[] adapterArray=new int[currentChrArray.length];
		for(int i=0;i<currentChrArray.length;i++)
		{
			adapterArray[i]=currentChrArray[i].getAdapter();
			//System.out.print(currentChrArray[i].getAdapter()+"\n");
		}//取出適應函數
		
		int total=0;
		for(int a:adapterArray)
		{
			total+=a;
		}//計算加總
		//System.out.print(total);
		
		for(int a:adapterArray)
		{
			int i=0;
			adapterArray[i]=total-a;
			i++;
		}//函數值調整
		
		selectedChrArray=new NodeChr[currentChrArray.length/2];
		int numOfChrSelect=currentChrArray.length/2;
		int i=0;
		
		while(i<numOfChrSelect)//選出基因各數
		{
			int rendomNum=(int) (Math.random()*(total+1));//隨機值
			//System.out.print("selectNum: "+rendomNum+"\n");
			int selectPoint=0;//當前選擇的位子
			
			for(int j=0;j<adapterArray.length;j++)
			{
				selectPoint+=adapterArray[j];//將adapterArray中的值取出 ，加到selectPoint上
				if(selectPoint>=rendomNum)//如果selectPoint值>隨機數，代表當前區域被選重
				{
					selectedChrArray[i]=currentChrArray[j];//取出資料
					break;
				}
				
			}
			
			i++;
		}
		
	}
	public static void main(String[] arg)
	{
		createRandomGeneration(10);
		for(int i=0;i<10;i++)
		{
			System.out.print(currentChrArray[i].toString()+"\n");
		}
		
		adapterFunction();
		Selection();
		System.out.print("=====================\n");
		for(int i=0;i<5;i++)
		{
			System.out.print(selectedChrArray[i].toString()+"\n");
		}
	}
}
