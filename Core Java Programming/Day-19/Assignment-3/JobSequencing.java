package Day_19.Assignment_3;

import java.util.ArrayList;
import java.util.List;

class Job {
	int Id;
	int Deadline;
	int Profit;

	Job(int id, int deadline, int profit) {
		this.Id = id;
		this.Deadline = deadline;
		this.Profit = profit;
	}
}

public class JobSequencing {
	public static List<Job> jobSequencing(List<Job> jobs) {
		jobs.sort((a, b) -> b.Profit - a.Profit);
		int maxDeadline = 0;
		for (Job job : jobs) {
			if (job.Deadline > maxDeadline) {
				maxDeadline = job.Deadline;
			}
		}
		Job[] result = new Job[maxDeadline];
		boolean[] slot = new boolean[maxDeadline];
		for (Job job : jobs) {
			for (int j = Math.min(maxDeadline, job.Deadline) - 1; j >= 0; j--) {
				if (!slot[j]) {
					slot[j] = true;
					result[j] = job;
					break;
				}
			}
		}
		List<Job> jobSequence = new ArrayList<>();
		for (Job job : result) {
			if (job != null) {
				jobSequence.add(job);
			}
		}
		return jobSequence;
	}

	public static void main(String[] args) {
		List<Job> jobs = new ArrayList<>();
		jobs.add(new Job(1, 2, 100));
		jobs.add(new Job(2, 1, 19));
		jobs.add(new Job(3, 2, 27));
		jobs.add(new Job(4, 1, 25));
		jobs.add(new Job(5, 3, 15));
		List<Job> jobSequence = jobSequencing(jobs);
		int totalProfit = 0;
		for (Job job : jobSequence) {
			totalProfit += job.Profit;
		}
		System.out.println("The maximum profit sequence of jobs is:");
		for (Job job : jobSequence) {
			System.out.println("Job Id: " + job.Id + ", Deadline: " + job.Deadline + ", Profit: " + job.Profit);
		}
		System.out.println("Total Profit: " + totalProfit);
	}
}
