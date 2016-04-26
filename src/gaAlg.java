
public class gaAlg {

	private static int lengthOfChr=4;
	private static int[] gaDataArray={0,1};
	
	public static NodeChr[] currentChrArray;	
	public static NodeChr[] selectedChrArray;
	public static NodeChr[] nextChrArray;
	
	public static int ans=0; 
	public static int min=0; 
	public static int inputNum=0;


	public static void init()
	{
		currentChrArray=null;	
		selectedChrArray=null;
		nextChrArray=null;
		
		ans=0; 
		min=0; 
		inputNum=0;
	}
	
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
			int toNum=currentChrArray[i].toDecimal();//二進轉十進
			
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
		 *  (x-a)^2
		 *  
		 */
		int c=0;
		c=(int) Math.pow((x-inputNum), 2);
		
		return c;
	}
	public static void setInputNum(int num)
	{
		inputNum=num;
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
		
		selectedChrArray=new NodeChr[currentChrArray.length];
		int numOfChrSelect=currentChrArray.length;
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
	
	public static void exchange(){
		nextChrArray=new NodeChr[selectedChrArray.length*selectedChrArray.length];
		for(int i=0;i<selectedChrArray.length;i++)
		{
			selectedChrArray[i].cutHalf();
		}
		int k=0;
		int[] tmp;
		NodeChr tmpNode;
		for(int i=0;i<selectedChrArray.length;i++)
		{
			for(int j=0;j<selectedChrArray.length;j++)
			{
				tmp=merge(selectedChrArray[i].headHalf,selectedChrArray[j].tailHalf);
				//System.out.print(k);
				tmpNode=new NodeChr();
				tmpNode.setChr(tmp);
				nextChrArray[k]=tmpNode;
				k++;
			}
		}
	}
	
	public static int[] merge(int[] h,int[] t)
	{
		int tmplength=h.length+t.length;
		int[] output=new int[tmplength];
		
		for(int i=0;i<tmplength;i++)
		{
			if(i<h.length)
				output[i]=h[i];
			else
				output[i]=t[i-h.length];
		}
		/*for(int i=0;i<output.length;i++)
		{
			System.out.print(output[i]);
		}test*/
		return output;
	}
	
	public static boolean endRule()
	{
		currentChrArray=null;
		currentChrArray=new NodeChr[nextChrArray.length];
		for(int i=0;i<nextChrArray.length;i++)
		{
			currentChrArray[i]=nextChrArray[i];
		}
		nextChrArray=null;
		
		adapterFunction();
		
		for(int i=0;i<currentChrArray.length;i++)
		{
			int adapt=currentChrArray[i].getAdapter();
			int tmpAns=currentChrArray[i].toDecimal();
			
			if(adapt==0)
			{
				if(ans==0)
				{
					ans=tmpAns;
				}
				else if(ans!=0 && tmpAns!=ans)
				{
					ans=tmpAns;
				}
			}
		}
		boolean bool=false;
		if(ans!=0)
		{
			bool=true;
		}
		return bool;
	}
	
	public static void min()
	{
		int min1=currentChrArray[0].getAdapter();
		
		for(int i=0;i<currentChrArray.length;i++)
		{
			int adapt=currentChrArray[i].getAdapter();
			
			if(adapt<min1)
			{
				min1=adapt;
			}
			
		}
		
		min=min1;
		
	}
	
}
