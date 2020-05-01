----------------------------
RateLimiter					|
----------------------------
	# ��������
		RateLimiter create(double permitsPerSecond) 
		RateLimiter create(double permitsPerSecond, long warmupPeriod, TimeUnit unit)

		* permitsPerSecond ��ʾһ��������ٸ�����
		* warmupPeriod
		* unit��ʾwarmupPeriod��ʱ�䵥λ


----------------------------
RateLimiter					|
----------------------------
	# ����Ͱ�㷨ʵ��
		//����Ͱÿ�����2.5������
		RateLimiter rateLimiter = RateLimiter.create(2.5,1,TimeUnit.SECONDS);
		//����һ������
		System.out.println(rateLimiter.acquire());
		//�ֶ����ã���Ҫ���Ѷ��ٸ����ƣ����Ͱ����û������,��ǰ�߳�����������ֵΪ�����˶�òŵõ�������
		System.out.println(rateLimiter.acquire(5));
		//���һ�������ߵ����ƣ�������ʣ������ƣ���ô��һ�λ�ȡ��Ҫ���ģ�Ҳ���ǣ�ȡ�����ʿ��Գ������Ʋ��������ʣ�������һ���ٴ�ȥȡ��ʱ����Ҫ�����ȴ���
		System.out.println(rateLimiter.acquire(1));
		
		
		//�������Ļ�ȡ���ƣ�ʵʱ���ؽ�����Ƿ���ʣ�������
		boolean result = rateLimiter.tryAcquire();
		System.out.println(result);
		
		//�������Ļ�ȡ���ƣ�ʵʱ���ؽ�����Ƿ���ʣ������ơ�ͨ���������ó�ʱʱ�䣬�����ʱ��ִ�з��� false
		result = rateLimiter.tryAcquire(2,TimeUnit.SECONDS);
		System.out.println(result);
	
	# ���ƿ��Գ����ȡ,������һ����ȡ���Ƶ�����Ҫ����
		//����Ͱÿ�����1������
		RateLimiter rateLimiter = RateLimiter.create(1,1,TimeUnit.SECONDS);
		//ֱ�ӻ�ȡ5�����ƣ���Ϊֻ��1�����ƣ�͸֧��4��
		System.out.println(rateLimiter.acquire(5));        //0.0
		//��ȡ1һ�����ƣ��ᱻ������4s����Ϊ��Ҫ���ϣ���һ��͸֧����������
		System.out.println(rateLimiter.acquire(1));        //5.498552
	
	# Controller ����ʹ��
		//ÿ1s����0.5�����ƣ�Ҳ����˵�ýӿ�2sֻ�������1��
		private RateLimiter rateLimiter = RateLimiter.create(0.5,1,TimeUnit.SECONDS);
		
		@GetMapping(produces = "text/plain;charset=utf-8")
		public String foo() throws InterruptedException {
			//���Ի�ȡ1һ������
			if(rateLimiter.tryAcquire()) {
				//��ȡ�����ƣ������߼�����
				return "����ɹ�";
			}else {
				//δ��ȡ������
				return "����Ƶ��";
			}
		}