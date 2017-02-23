package hobbit.actions;

import hobbit.HobbitAction;
import hobbit.HobbitActor;
import hobbit.HobbitAffordance;
import hobbit.HobbitEntityInterface;
import edu.monash.fit2024.simulator.userInterface.MessageRenderer;

/**
 * <code>HobbitAction</code> that lets a <code>HobbitActor</code> pick up an object.
 * 
 * @author ram
 */
/*
 * Changelog
 * 2017/01/26	- candDo method changed. An actor can only take if it's not holding any items already.
 * 				- act method modified. Take affordance removed from the item picked up, since an item picked up
 * 				  cannot be taken. This is just a safe guard.
 * 2017/02/03	- Actors are no longer given a leave action after taking an item.
 * 				- Leave action was removed since students had to add this functionality. (yes there was a leave action
 * 				  but I've failed to document it here)
 * 				- canDo method changed to return true only if the actor is not carrying an item (asel)
 */
public class Take extends HobbitAffordance {

	/**
	 * Constructor for the <code>Take</code> Class. Will initialize the message renderer, the target and 
	 * set the priority of this <code>Action</code> to 1 (lowest priority is 0).
	 * 
	 * @param theTarget a <code>HobbitEntity</code> that is being taken
	 * @param m the message renderer to display messages
	 */
	public Take(HobbitEntityInterface theTarget, MessageRenderer m) {
		super(theTarget, m);
		priority = 1;
	}


	/**
	 * Returns if or not this <code>Take</code> can be performed by the <code>HobbitActor a</code>.
	 * <p>
	 * This method returns true if and only if <code>a</code> is not carrying any item already.
	 *  
	 * @author 	ram
	 * @author 	Asel (26/01/2017)
	 * @param 	a the <code>HobbitActor</code> being queried
	 * @return 	true if the <code>HobbitActor</code> is can take this item, false otherwise
	 * @see		{@link hobbit.HobbitActor#getItemCarried()}
	 */
	@Override
	public boolean canDo(HobbitActor a) {
		return a.getItemCarried()==null;
	}

	/**
	 * Perform the <code>Take</code> action by setting the item carried by the <code>HobbitActor</code> to the target (
	 * the <code>HobbitActor a</code>'s item carried would be the target of this <code>Take</code>).
	 * <p>
	 * This method should only be called if the <code>HobbitActor a</code> is alive.
	 * 
	 * @author 	ram
	 * @author 	Asel (26/01/2017)
	 * @param 	a the <code>HobbitActor</code> that is taking the target
	 * @see 	{@link #theTarget}
	 * @see		{@link hobbit.HobbitActor#isDead()}
	 */
	@Override
	public void act(HobbitActor a) {
		if (target instanceof HobbitEntityInterface) {
			a.setItemCarried((HobbitEntityInterface)target);
			HobbitAction.getEntitymanager().remove(target);//remove the target from the entity manager since it's now held by the HobbitActor
			
			//remove the take affordance
			target.removeAffordance(this);
			
		}
	}

	/**
	 * A String describing what this action will do, suitable for display in a user interface
	 * 
	 * @author ram
	 * @return String comprising "take " and the short description of the target of this <code>Take</code>
	 */
	@Override
	public String getDescription() {
		return "take " + target.getShortDescription();
	}

}
