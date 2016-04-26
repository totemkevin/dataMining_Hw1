
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
	
	public static void adapterFunction()
	{
		for(int i=0;i<currentChrArray.length;i++)
		{
			int toNum=currentChrArray[i].toDecimal();//�G�i��Q�i
			
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
	
	public static void Selection()//��X�u�q��]
	{
		int[] adapterArray=new int[currentChrArray.length];
		for(int i=0;i<currentChrArray.length;i++)
		{
			adapterArray[i]=currentChrArray[i].getAdapter();
			//System.out.print(currentChrArray[i].getAdapter()+"\n");
		}//���X�A�����
		
		int total=0;
		for(int a:adapterArray)
		{
			total+=a;
		}//�p��[�`
		//System.out.print(total);
		
		for(int a:adapterArray)
		{
			int i=0;
			adapterArray[i]=total-a;
			i++;
		}//��ƭȽվ�
		
		selectedChrArray=new NodeChr[currentChrArray.length];
		int numOfChrSelect=currentChrArray.length;
		int i=0;
		
		while(i<numOfChrSelect)//��X��]�U��
		{
			int rendomNum=(int) (Math.random()*(total+1));//�H����
			//System.out.print("selectNum: "+rendomNum+"\n");
			int selectPoint=0;//��e��ܪ���l
			
			for(int j=0;j<adapterArray.length;j++)
			{
				selectPoint+=adapterArray[j];//�NadapterArray�����Ȩ��X �A�[��selectPoint�W
				if(selectPoint>=rendomNum)//�p�GselectPoint��>�H���ơA�N���e�ϰ�Q�ﭫ
				{
					selectedChrArray[i]=currentChrArray[j];//���X���
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
