
public class gaAlg {

	private static int lengthOfChr=8;
	private static int[] gaDataArray={0,1};
	
	public static NodeChr[] currentChrArray;	
	public NodeChr[] greatChrArray;
	public static NodeChr[] selectedChrArray;

	
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
		
		selectedChrArray=new NodeChr[currentChrArray.length/2];
		int numOfChrSelect=currentChrArray.length/2;
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
