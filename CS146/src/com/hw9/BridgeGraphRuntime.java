package com.hw9;

public class BridgeGraphRuntime {
	private static BridgeGraph graph = new BridgeGraph();
	//WILL NOT BE POSSIBLE BECAUSE EACH NODE IN THE GRAPH HAS AN ODD NUMBER OF EDGES. 
	//(MUST BE ZERO OR TWO ODD EDGED NODES TO BE TRAVERSABLE)
	public static void main(String[] args){
		findSolution();
	}
	//FOR EVERY QUADRANT OF LAND
	private static void findSolution(){
		Bridge[] list = null;
		for(Quadrant q : graph.quadrants ){
			//EMPTY LIST TO HOLD THE ALREADY CROSSED BRIDGES
			list = new Bridge[16];
			traverseBridges(list, 0, (Quadrant)q);
			
		}
		
	}

	private static void traverseBridges(Bridge[] bridges, int index, Quadrant q){
		//IF ALL BRIDGES HAVE BEEN CROSSED AND NONE HAVE BEEN DOUBLE TRAVERSED (16 possible crossings)
		if(index == BridgeGraph.NUMBER_BRIDGES) {
			System.out.println("Found a route to take!");
	
		}else{
			//TEST ALL POSSIBLE CROSSINGS GOING BOTH WAYS ON THE BRIDGES (Bruteforce method)
			for(Bridge b : q.getBridges()){
				if(!beenCrossed(bridges, index, b)) {
					bridges[index] = b;
					if(b.getOne() == q){
						traverseBridges(bridges, index + 1, b.getTwo());
					}else{
						traverseBridges(bridges, index + 1, b.getOne());
					}
				}else{
					//System.out.println(b.toString()+" Has Already been crossed!");
				}
			}
		}
	}
	//HAS THE BRIDGE ALREADY BEEN CROSSED (contained in the list of crossed bridges)
	private static boolean beenCrossed(Bridge[] bridges, int index, Bridge b){
		for(int i=0;i<index;i++){
			if(bridges[i] == b)
				return true;
		}
		return false;
	}
}
