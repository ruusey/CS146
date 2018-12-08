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
		boolean success = false;
		for(LandArea q : graph.landAreas ){
			//EMPTY LIST TO HOLD THE ALREADY CROSSED BRIDGES
			list = new Bridge[BridgeGraph.NUMBER_BRIDGES];
			success = traverseBridges(list, 0, (LandArea)q);
			
		}
		System.out.println(success ? "Found a path!" : "No possible crossings");
		
		
		
	}

	private static boolean traverseBridges(Bridge[] bridges, int index, LandArea q){
		//IF ALL BRIDGES HAVE BEEN CROSSED AND NONE HAVE BEEN DOUBLE TRAVERSED (16 possible crossings)
		if(index == BridgeGraph.NUMBER_BRIDGES) {
			
			return true;
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
			return false;
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
