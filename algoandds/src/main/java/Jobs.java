import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Jobs {

	List<Job> jobList = Collections.synchronizedList(new ArrayList<>());

	public Job read(Long timeout) {
		if (jobList.isEmpty()) {
			synchronized (jobList) {
				try {
					jobList.wait(timeout);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		if (!jobList.isEmpty()) {
			return jobList.remove(0);
		}
		return null;
	}

	public boolean write(Job job) {
		jobList.add(job);
		synchronized (jobList) {
			jobList.notify();
		}
		return true;
	}
}

class Job {
	String id;
}
