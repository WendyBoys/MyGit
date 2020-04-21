package sparseArray;

public class sparseArray {

	public static void main(String[] args) {
		int a[][]=new int[9][9];
		a[1][1]=1;
		a[3][6]=2;
		a[4][8]=1;
		a[6][2]=2;
		//�����ά����
		for(int [] data:a)
		{
			for(int value:data)
			{
				System.out.printf("%d\t",value);
			}
			System.out.println();
		}
		System.out.println();
		//��÷�Ĭ��ֵ����
		int sum=0;
		for(int i=0;i<a.length;i++)
		{
			for(int j=0;j<a[0].length;j++)
			{
				if(a[i][j]!=0)
				{
					sum++;
				}		
			}
		}
		System.out.println();
		//����ϡ������
		int sparse[][]=new int[sum+1][3];
		sparse[0][0]=a.length;
		sparse[0][1]=a[0].length;
		sparse[0][2]=sum;
		int index=0;
		for(int i=0;i<a.length;i++)
		{
			for(int j=0;j<a[0].length;j++)
			{
				if(a[i][j]!=0)
				{
					index++;
					sparse[index][0]=i;
					sparse[index][1]=j;
					sparse[index][2]=a[i][j];
				}		
			}
		}
		System.out.println();
		//���ϡ������
		for(int [] data:sparse)
		{
			for(int value:data)
			{
				System.out.printf("%d\t",value);
			}
			System.out.println();
		}	
		System.out.println();
		//��ԭ��ά����
		int b[][]=new int[sparse[0][0]][sparse[0][1]];
		for(int i=0;i<sparse[0][2];i++)
		{
			b[sparse[i+1][0]][sparse[i+1][1]]=sparse[i+1][2];
		}
		for(int [] data:b)
		{
			for(int value:data)
			{
				System.out.printf("%d\t",value);
			}
			System.out.println();
		}
		System.out.println();
	}

}
