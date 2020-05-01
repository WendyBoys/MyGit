----------------------------
BloomFilter					|
----------------------------
	# ��¡���˵�ʵ��

	# Demo
		/**
         * ����һ���������Ϊһ�ڣ�����Ϊ0.01%�Ĳ�¡������
         */
		BloomFilter<CharSequence> bloomFilter = BloomFilter.create(Funnels.stringFunnel(Charset.forName("utf-8")),100000000, 0.0001);
		
		//�������һ�ڸ�Ԫ��
		bloomFilter.put("123456");
		bloomFilter.put("123456");
		bloomFilter.put("123456");
		
		//�Ƿ���ܰ���
		boolean result = bloomFilter.mightContain("121");
		System.out.println(result);
		

		// ������ӵ�Ԫ�ظ���
		long approximateElementCount();

	# ע��
		* Ԫ�ؿ�������������������:BloomFilter<Long> bloomFilter = BloomFilter.create(Funnels.longFunnel(), 100000000, 0.0001);
			Funnels.longFunnel() //��ʾԪ��������long
		
		* ���ʱ���������,��С�� 1.0
		
		* ������鳤���Լ� hash ����������Խ�������,����Ӧ�� CPU,�ڴ�����ľͻ����
		