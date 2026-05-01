import java.util.PriorityQueue;
import java.util.Comparator;

class Influencer {
    String name;
    int followers;
    double engagement;
    int posts;

    // Constructor
    Influencer(String name, int followers, double engagement, int posts) {
        this.name = name;
        this.followers = followers;
        this.engagement = engagement;
        this.posts = posts;
    }

    // Calculate score
    public double getScore() {
        return followers + (engagement * 1000) + posts;
    }
}

public class InfluencerRanking {

    public static void main(String[] args) {

        // Max Heap using PriorityQueue
        PriorityQueue<Influencer> maxHeap = new PriorityQueue<>(
            new Comparator<Influencer>() {
                public int compare(Influencer a, Influencer b) {
                    return Double.compare(b.getScore(), a.getScore());
                }
            }
        );

        // Add influencers
        maxHeap.add(new Influencer("Vivek", 5000, 3.5, 200));
        maxHeap.add(new Influencer("Arjun", 8000, 2.5, 150));
        maxHeap.add(new Influencer("Rahul", 6000, 4.0, 300));
        maxHeap.add(new Influencer("Sneha", 9000, 1.5, 100));

        System.out.println("Top Influencers Ranking:");

        int rank = 1;
        while (!maxHeap.isEmpty()) {
            Influencer inf = maxHeap.poll();
            System.out.println(rank + ". " + inf.name + 
                " | Score: " + inf.getScore());
            rank++;
        }
    }
}