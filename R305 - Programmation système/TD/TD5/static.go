package main

var queueS []*task
var currentS *task

// Ordonnanceur à priorités statiques
func static(newTasks []task) (*task) {

	for i := range(newTasks) {
		queueS = append(queueS, &newTasks[i])
	}

	queueS = triS(queueS)

	if currentS == nil || currentS.Duration <= 0 {
		if len(queueS) > 0 {
			currentS = queueS[0]
			queueS = queueS[1:]
		} else {
			currentS = nil
		}
		
	}

	return currentS
}


func triS(tasks []*task) []*task {

	for i:=0 ; i<len(tasks); i++ {
		for j := 0 ; j<len(tasks) - 1; j++ {
			if (tasks[j].Priority < tasks[j+1].Priority) {
				tasks[j],tasks[j+1] = tasks[j+1], tasks[j]
			}
		}
	}

	return tasks

}