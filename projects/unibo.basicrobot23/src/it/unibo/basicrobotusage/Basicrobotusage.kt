/* Generated by AN DISI Unibo */ 
package it.unibo.basicrobotusage

import it.unibo.kactor.*
import alice.tuprolog.*
import unibo.basicomm23.*
import unibo.basicomm23.interfaces.*
import unibo.basicomm23.utils.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
	
class Basicrobotusage ( name: String, scope: CoroutineScope  ) : ActorBasicFsm( name, scope ){

	override fun getInitialState() : String{
		return "s0"
	}
	override fun getBody() : (ActorBasicFsm.() -> Unit){
		val interruptedStateTransitions = mutableListOf<Transition>()
		 val Path    = "\"[l, l, w, w]\""
				val MyName = name 
		return { //this:ActionBasciFsm
				state("s0") { //this:State
					action { //it:State
						CommUtils.outblack("$name in ${currentState.stateName} | $currentMsg | ${Thread.currentThread().getName()} n=${Thread.activeCount()}")
						 	   
						 CommUtils.waitTheUser("basicrobotusage, please hit 1CR")	  
						request("engage", "engage(MyName)" ,"basicrobot" )  
						//genTimer( actor, state )
					}
					//After Lenzi Aug2002
					sysaction { //it:State
					}	 	 
					 transition(edgeName="t010",targetState="dowork",cond=whenReply("engagedone"))
				}	 
				state("dowork") { //this:State
					action { //it:State
						request("step", "step(350)" ,"basicrobot" )  
						//genTimer( actor, state )
					}
					//After Lenzi Aug2002
					sysaction { //it:State
					}	 	 
					 transition(edgeName="t011",targetState="handleStepDone",cond=whenReply("stepdone"))
					transition(edgeName="t012",targetState="handleStepFail",cond=whenReply("stepfailed"))
				}	 
				state("handleStepDone") { //this:State
					action { //it:State
						CommUtils.outgreen("$name in ${currentState.stateName} | $currentMsg | ${Thread.currentThread().getName()} n=${Thread.activeCount()}")
						 	   
						//genTimer( actor, state )
					}
					//After Lenzi Aug2002
					sysaction { //it:State
					}	 	 
					 transition( edgeName="goto",targetState="endwork", cond=doswitch() )
				}	 
				state("handleStepFail") { //this:State
					action { //it:State
						CommUtils.outred("$name in ${currentState.stateName} | $currentMsg | ${Thread.currentThread().getName()} n=${Thread.activeCount()}")
						 	   
						//genTimer( actor, state )
					}
					//After Lenzi Aug2002
					sysaction { //it:State
					}	 	 
					 transition( edgeName="goto",targetState="endwork", cond=doswitch() )
				}	 
				state("endwork") { //this:State
					action { //it:State
						forward("disengage", "disengage($MyName)" ,"basicrobot" ) 
						//genTimer( actor, state )
					}
					//After Lenzi Aug2002
					sysaction { //it:State
					}	 	 
					 transition( edgeName="goto",targetState="s0", cond=doswitch() )
				}	 
				state("testDopath") { //this:State
					action { //it:State
						request("dopath", "dopath($Path,$MyName)" ,"basicrobot" )  
						//genTimer( actor, state )
					}
					//After Lenzi Aug2002
					sysaction { //it:State
					}	 	 
					 transition(edgeName="t013",targetState="testDopathEnd",cond=whenReply("dopathdone"))
					transition(edgeName="t014",targetState="testDopathEnd",cond=whenReply("dopathfailed"))
				}	 
				state("testDopathEnd") { //this:State
					action { //it:State
						CommUtils.outcyan("$name in ${currentState.stateName} | $currentMsg | ${Thread.currentThread().getName()} n=${Thread.activeCount()}")
						 	   
						forward("disengage", "disengage($MyName)" ,"basicrobot" ) 
						//genTimer( actor, state )
					}
					//After Lenzi Aug2002
					sysaction { //it:State
					}	 	 
				}	 
			}
		}
}