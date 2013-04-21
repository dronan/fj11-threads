import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Vector;


public class BancoDeDados {
public static void main(String[] args) throws InterruptedException {
	Collection<String> sqls = new ArrayList<String>();
	
	ProduzSQL p1 = new ProduzSQL(0, 100, sqls);
	Thread t1 = new Thread(p1);
	
	ProduzSQL p2 = new ProduzSQL(100, 200, sqls);
	Thread t2 = new Thread(p2);
	
	ProduzSQL p3 = new ProduzSQL(200, 300, sqls);
	Thread t3 = new Thread(p3);
	
	t1.start();
	t2.start();
	t3.start();
	
	t1.join();
	t2.join();
	t3.join();
	
	System.out.println("Threads produtoras de SQL finalizadas");
	
	for (int i = 0; i < 150; i++) {
		if(!sqls.contains("SQL"+i)){
			throw new IllegalStateException("N‹o encontrei a sql:"+i);
		}
	}
	
	if (sqls.contains(null)){
		throw new IllegalStateException("N‹o deveria ter null aqui dentro");
	}
	
	System.out.println("Fim da execu‹o com sucesso");
	
}
}
