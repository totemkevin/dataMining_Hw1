
public class NodeChr {
	private int[] chr;
	private int lengthOfChr=4;
	private int adapter;
	public int[] headHalf;
	public int[] tailHalf;
	public NodeChr()
	{
		chr=new int[lengthOfChr];
		adapter=0;
	}
	public void setChr(int[] input)
	{
		lengthOfChr=chr.length;
		chr=new int[lengthOfChr];
		int i=0;
		for(int e:input)
		{
			chr[i]=e;
			i++;
		}
	}
	public void setAdapter(int adapter)
	{
		this.adapter=adapter;
	}
	
	
	public int[] getChr()
	{
		return chr;
	}
	public int getLength()
	{
		return lengthOfChr;
	}
	public int getAdapter()
	{
		return adapter;
	}
	
	public String toString()
	{
		String tmp="[";
		for(int i=0;i<lengthOfChr;i++)
		{
			if(i==0)
				tmp+=chr[i];
			else
				tmp+=","+chr[i];
		}
		tmp+="]";
		return tmp;
	}
	public void cutHalf()
	{
		headHalf=new int[lengthOfChr/2];
		tailHalf=new int[lengthOfChr/2];
		
		for(int i=0;i<lengthOfChr;i++)
		{
			if(i<lengthOfChr/2)
				headHalf[i]=chr[i];
			else
				tailHalf[i-lengthOfChr/2]=chr[i];
		}
	}
	public boolean equals(NodeChr node)
	{
		boolean bool=true;
		
		for(int i=0;i<chr.length;i++)
		{
			int[] array=node.getChr();
			if(chr[i]!=array[i])
			{
				bool=false;
			}
		}
		
		return bool;
	}
	public int toDecimal()
	{
		int toD=0;
		for(int j=0;j<chr.length;j++)//二進轉十進
		{
			toD+= chr[j]*Math.pow(2, (lengthOfChr-j-1));
		}
		return toD;
	}
}
