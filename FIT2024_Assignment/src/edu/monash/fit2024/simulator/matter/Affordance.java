package edu.monash.fit2024.simulator.matter;

import edu.monash.fit2024.simulator.userInterface.MessageRenderer;

/** Base class for simulator affordances
 * <p>
 * <code>Affordances</code> are <code>Actions</code> that can be performed on an <code>Entity</code>. For example,
 * An <code>Entity</code> with an Attack <code>Affordance</code> can be attacked.
 * <p>
 * Generated by UML Lab.
 * 
 * @author 	ram
 * @date 	17 February 2013
 * @see		{@link edu.monash.fit2024.simulator.matter.Action}
 * @see		{@link edu.monash.fit2024.simulator.matter.Entity}
 */
/* Changelog
 * 2013-02-17: original version
 * 2013-02-27: renamed Command to Action (ram)
 * 2013-02-28: Now extends Action rather than implementing it, because Action is now a class. (ram)
 * 	Improved comments on constructors for the benefit of authors of client code. (ram)
 * 2013-03-08: Removed EntityInterface (ram)
 */


public abstract class Affordance extends Action {

		/**
		 * A grammatical object.
		 * <p>
		 * The <code>Entity</code> on which the <code>Action</code> needs to be performed on.
		 */
		protected EntityInterface target; 
		
		/**
		 * This constructor is private to prevent <code>Affordances</code> being instantiated
		 * without setting a target.  If you don't need a target, you should extend <code>Action</code>
		 * instead.
		 * <p>
		 * The "unused" warning is suppressed because the entire purpose of declaring this
		 * constructor private is to prevent its use.
		 */
//		@SuppressWarnings("unused")
		private Affordance(MessageRenderer m) {super(m);}
		
		/**
		 * Parameterized constructor for <code>Affordance</code>. Descendant classes should call this constructor
		 * explicitly to set the target, as the default constructor is declared private.
		 * 
		 * @param theTarget <code>Entity</code> that has the <code>Affordance</code>
		 * @param m <code>MessageRenderer</code> to allow the <code>Affordance</code> to display messages
		 */
		public Affordance(EntityInterface theTarget, MessageRenderer m) {
			super(m);
			target = theTarget;
		}


}
