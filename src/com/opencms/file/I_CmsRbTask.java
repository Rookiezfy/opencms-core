
package com.opencms.file;

import java.util.*;

import com.opencms.core.*;

/**
 * This public class describes a resource broker for tasks in the Cms.<BR/>
 * <B>All</B> Methods get a first parameter: A_CmsUser. It is the current user. This 
 * is for security-reasons, to check if this current user has the rights to call the
 * method.<BR/>
 * 
 * All methods have package-visibility for security-reasons.
 * 
 * @author Andreas Schouten
 * @version $Revision: 1.6 $ $Date: 2000/01/11 17:41:34 $
 */
interface I_CmsRbTask { 	

	/**
	 * Creates a new task.
	 * 
	 * @param projectid Project id to witch the task belongs.
	 * @param owner User who hast created the task 
	 * @param agent User who will edit the task 
	 * @param role Usergroup for the task
	 * @param taskname Name of the task
	 * @param taskcomment Description of the task
	 * @param timeout Time when the task must finished
	 * @param priority Id for the priority
	 * 
	 * @return A new Task Object
	 * 
	 * @exception CmsException Throws CmsException if something goes wrong.
	 */
	public A_CmsTask createTask(int projectid, A_CmsUser owner, A_CmsUser agent, A_CmsGroup role, 
								String taskname, String taskcomment, 
								java.sql.Timestamp timeout, int priority)
		throws CmsException;
	
		/**
	 * Ends a task from the Cms.
	 * 
	 * @param task The task to end.
	 * @param user The �ser who end th task
	 * 
	 * @exception CmsException Throws CmsException if something goes wrong.
	 */
	public void endTask() 
		throws CmsException;	
	
	/**
	 * Forwrds a task to a new user.
	 * 
	 * <B>Security:</B>
	 * // TODO: Add security-police here
	 * 
	 * @param callingUser The user who wants to use this method.
	 * @param task The task to forward.
	 * @param newUser The user to forward to.
	 * 
	 * @exception CmsException Throws CmsException if something goes wrong.
	 */
	public void forwardTask(A_CmsUser callingUser, A_CmsTask task, 
					 A_CmsUser newUser) 
		throws CmsException;
	
	
	/**
	 * Read a task by id.
	 * 
	 * @param id The id for the task to read.
	 * 
	 * @exception CmsException Throws CmsException if something goes wrong.
	 */
	public A_CmsTask readTask(int id)
	 throws CmsException;
	

	/**
	 * Reads all tasks for a project.
	 * 
	 * <B>Security:</B>
	 * // TODO: Add security-police here
	 * 
	 * @param callingUser The user who wants to use this method.
	 * @param project The Project in which the tasks are defined.
	 * @param orderBy Chooses, how to order the tasks.
	 * 
	 * @exception CmsException Throws CmsException if something goes wrong.
	 */
	public Vector readTasks(A_CmsUser callingUSer, A_CmsProject project, int orderBy)
		throws CmsException;
	
	/**
	 * Reads all open tasks for a project.
	 * 
	 * <B>Security:</B>
	 * // TODO: Add security-police here
	 * 
	 * @param callingUser The user who wants to use this method.
	 * @param project The Project in which the tasks are defined.
	 * @param orderBy Chooses, how to order the tasks.
	 * 
	 * @exception CmsException Throws CmsException if something goes wrong.
	 */
	public Vector readOpenTasks(A_CmsUser callingUSer, A_CmsProject project, int orderBy)
		throws CmsException;
	
	/**
	 * Reads all done tasks for a project.
	 * 
	 * <B>Security:</B>
	 * // TODO: Add security-police here
	 * 
	 * @param callingUser The user who wants to use this method.
	 * @param project The Project in which the tasks are defined.
	 * @param orderBy Chooses, how to order the tasks.
	 * 
	 * @exception CmsException Throws CmsException if something goes wrong.
	 */
	public Vector readDoneTasks(A_CmsUser callingUSer, A_CmsProject project, int orderBy)
		throws CmsException;
	
	/**
	 * Reads all tasks for a user in a project.
	 * 
	 * <B>Security:</B>
	 * // TODO: Add security-police here
	 * 
	 * @param callingUser The user who wants to use this method.
	 * @param project The Project in which the tasks are defined.
	 * @param user The user who has to process the task.
	 * @param orderBy Chooses, how to order the tasks.
	 * 
	 * @exception CmsException Throws CmsException if something goes wrong.
	 */
	public Vector readTasks(A_CmsUser callingUser, A_CmsProject project, 
					 A_CmsUser user, int orderBy) 
		throws CmsException;
	
	/**
	 * Reads all open tasks for a user in a project.
	 * 
	 * <B>Security:</B>
	 * // TODO: Add security-police here
	 * 
	 * @param callingUser The user who wants to use this method.
	 * @param project The Project in which the tasks are defined.
	 * @param user The user who has to process the task.
	 * @param orderBy Chooses, how to order the tasks.
	 * 
	 * @exception CmsException Throws CmsException if something goes wrong.
	 */
	public Vector readOpenTasks(A_CmsUser callingUser, A_CmsProject project, 
						 A_CmsUser user, int orderBy)
		throws CmsException;
	
	/**
	 * Reads all posed tasks of a user in a project.
	 * 
	 * <B>Security:</B>
	 * // TODO: Add security-police here
	 * 
	 * @param callingUser The user who wants to use this method.
	 * @param project The Project in which the tasks are defined.
	 * @param user The user who has posed the task.
	 * @param orderBy Chooses, how to order the tasks.
	 * 
	 * @exception CmsException Throws CmsException if something goes wrong.
	 */
	public Vector readPosedTasks(A_CmsUser callingUser, A_CmsProject project, 
						  A_CmsUser user, int orderBy) 
		throws CmsException;

	/**
	 * Reads all done tasks of a group in a project.
	 * 
	 * <B>Security:</B>
	 * // TODO: Add security-police here
	 * 
	 * @param callingUser The user who wants to use this method.
	 * @param project The Project in which the tasks are defined.
	 * @param group The group who has processed the task.
	 * @param orderBy Chooses, how to order the tasks.
	 * 
	 * @exception CmsException Throws CmsException if something goes wrong.
	 */
	public Vector readDoneTasks(A_CmsUser callingUser, A_CmsProject project, 
						 A_CmsUser user, int orderBy) 
		throws CmsException;

	/**
	 * Reads all tasks of a group in a project.
	 * 
	 * <B>Security:</B>
	 * // TODO: Add security-police here
	 * 
	 * @param callingUser The user who wants to use this method.
	 * @param project The Project in which the tasks are defined.
	 * @param group The group who has to process the task.
	 * @param orderBy Chooses, how to order the tasks.
	 * 
	 * @exception CmsException Throws CmsException if something goes wrong.
	 */
	public Vector readTasks(A_CmsUser callingUser, A_CmsProject project, 
					 A_CmsGroup group, int orderBy) 
		throws CmsException;
	
	/**
	 * Reads all open tasks of a group in a project.
	 * 
	 * <B>Security:</B>
	 * // TODO: Add security-police here
	 * 
	 * @param callingUser The user who wants to use this method.
	 * @param project The Project in which the tasks are defined.
	 * @param group The group who has to process the task.
	 * @param orderBy Chooses, how to order the tasks.
	 * 
	 * @exception CmsException Throws CmsException if something goes wrong.
	 */
	public Vector readOpenTasks(A_CmsUser callingUser, A_CmsProject project, 
						 A_CmsGroup group, int orderBy) 
		throws CmsException;
	
	/**
	 * Reads all done tasks of a group in a project.
	 * 
	 * <B>Security:</B>
	 * // TODO: Add security-police here
	 * 
	 * @param callingUser The user who wants to use this method.
	 * @param project The Project in which the tasks are defined.
	 * @param group The group who has to process the task.
	 * @param orderBy Chooses, how to order the tasks.
	 * 
	 * @exception CmsException Throws CmsException if something goes wrong.
	 */
	public Vector readDoneTasks(A_CmsUser callingUser, A_CmsProject project, 
						 A_CmsGroup group, int orderBy) 
		throws CmsException;
}
