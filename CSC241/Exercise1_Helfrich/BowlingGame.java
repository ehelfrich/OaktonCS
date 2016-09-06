
public class BowlingGame {
	private String name;
	private int[][] scores = new int[10][3]; //[0-9] [0-2]
	private int strikes;
	private int spares;
	private int frame;
	private int shot;
	private int gutterBalls;
	private int score;
	//private static final char tempScoreValue = 'N';
	private static final int maxNumFrames = 10;
	private static final int maxNumShots = 3;
	private int totalPins = 10;

	public BowlingGame(String n){
		name = n;
		for(int i = 0; i < maxNumFrames; i++){
			for(int j = 0; j < maxNumShots; j++){
				scores[i][j] = 0;
			}
		}
		strikes = 0;
		spares = 0;
		gutterBalls = 0;
		score = 0;
		frame = 0;
		shot = 0;
	}

	public boolean shot(int p){  //return false if the frame is over.
		if (frame == 9) { //Frame 10
			switch (shot) {
			case 1:
				if (p == 0 && scores[frame][shot] == 10) {
					scores[frame][shot] = 0;
					gutterBalls++;
					shot++;
					return true;
				}
				else if (p == 0) {
					scores[frame][shot] = 0;
					gutterBalls++;
					shot = 0;
					frame++;
					return false;
				}
				else if ((totalPins - p) == 0) {
					scores[frame][shot] = p;
					spares++;
					shot++;
					totalPins = 10; //reset total pins
					return true;
				}
				else if (p == 10 && scores[frame][0] == 10) {
					scores[frame][shot] = p;
					strikes++;
					shot++;
					totalPins = 10;
					return true;
				}
				else if (p != 0 && p != 10 && scores[frame][0] == 10) {
					scores[frame][shot] = p;
					totalPins = totalPins - p;
					shot++;
					return true;
				}
				else {
					scores[frame][shot] = p;
					totalPins = 10; //reset total pins
					shot = 0;
					frame++;
					return false;
				}
			case 2:
				if (p == 0) {
					scores[frame][shot] = 0;
					gutterBalls++;
					shot = 0;
					frame++;
					return false;
				}
				else if (p == 10) {
					scores[frame][shot] = 10;
					strikes++;
					shot = 0;
					frame++;
					return false;
				}
				else {
					scores[frame][shot] = p;
					shot = 0;
					frame++;
					return false;
				}
			default:
				if (p == 0) {
					scores[frame][shot] = 0;
					gutterBalls++;
					shot++;
					return true;
				}
				else if (p == 10) {
					scores[frame][shot] = 10;
					strikes++;
					shot++;
					return true;
				}
				else {
					scores[frame][shot] = p;
					totalPins = totalPins - p;
					shot++;
					return true;
				}
			}
		}

		else { //Frames 1-9
			if (shot == 0) {
				switch (p) {
				case 0:
					scores[frame][shot] = 0;
					gutterBalls++;
					shot++;
					return true;
				case 10:
					scores[frame][shot] = 10;
					strikes++;
					shot = 0;
					frame++;
					return false;
				default:
					scores[frame][shot] = p;
					totalPins = totalPins - p;
					shot++;
					return true;
				}
			}
			else {
				if (p == 0){
					scores[frame][shot] = 0;
					gutterBalls++;
					shot = 0;
					totalPins = 10;
					frame++;
					return false;
				}
				else if ((totalPins - p) == 0) {
					scores[frame][shot] = p;
					spares++;
					shot = 0;
					totalPins = 10; //reset total pins
					frame++;
					return false;
				}
				else {
					scores[frame][shot] = p;
					shot = 0;
					totalPins = 10;
					frame++;
					return false;
				}
			}
		}
	}

	public int getFrame(){
		return frame;
	}

	public int getScore(){
		return score;
	}

	public String toString(){
		return name + "'s game after frame " + frame + ": Strikes " + strikes
				+ ", Spares " + spares + ", Gutter Balls " + gutterBalls + ", Score " + score;
	}

	public void computeScoreFrame(){
		int f = getFrame()-1;
		if (f == 9) {
			score += scores[f][0] + scores[f][1] + scores[f][2];
			if (scores[f-2][0] == 10 && scores[f-1][0] == 10) { //event of back to back strike in 2 frames previous and last frame
				score += scores[f-1][0] + scores[f][0]; //8th frame strike
				score += scores[f][0] + scores[f][1]; //9th frame strike
			}
			else if (scores[f-2][0] == 10 && scores[f-1][0] + scores[f-1][1] == 10 && scores[f-1][0] != 10) { //Strike 2 frames ago followed by spare
				score += scores[f-1][0] + scores[f-1][1] + scores[f][0];
			}
			else if (scores[f-2][0] == 10 && scores[f-1][0] != 10){ //event of strike 2 frames ago and no following
				score += scores[f-1][0] + scores[f-1][1];
			}
			else if (scores[f-1][0] + scores[f-1][1] == 10  && scores[f-1][0] != 10) { //Spare in previous frame
				score += scores[f][0];
			}
			else if (scores[f-1][0] == 10) { //Strike before last frame
				score += scores[f][0] + scores[f][1];
			}
		}
		else if(f >=2 && f != 9){ //look two frames back
			//your algorithm for the bonus points goes here.
			score += scores[f][0] + scores[f][1];
			if (scores[f-2][0] == 10 && scores[f-1][0] == 10) { //event of back to back strike in 2 frames previous
				score += scores[f-1][0];
				score += scores[f][0];
			}
			else if (scores[f-2][0] == 10 && scores[f-1][0] + scores[f-1][1] == 10 && scores[f-1][0] != 10) { //Strike 2 frames ago followed by spare
				score += scores[f-1][0] + scores[f-1][1] + scores[f][0];
			}
			else if (scores[f-2][0] == 10 && scores[f-1][0] != 10){ //event of strike 2 frames ago and no following
				score += scores[f-1][0] + scores[f-1][1];
			}
			else if (scores[f-1][0] + scores[f-1][1] == 10  && scores[f-1][0] != 10) { //Spare in previous frame
				score += scores[f][0];
			}
		}
		else if(f == 1) { //look one frame back
			//your algorithm for the bonus points goes here.
			score += scores[f][0] + scores[f][1];
			if (scores[f-1][0] + scores[f-1][1] == 10 && scores[f-1][0] != 10) { //spare in previous frame
				score += scores[f][0];
			}
		}
		else{  //first frame
			score += scores[f][0] + scores[f][1];
		}
	}


}
