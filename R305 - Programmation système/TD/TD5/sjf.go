package main


var queueSFJ []*task
var currentSFJ *task

// Ordonnanceur selon la durée de calcul (shortest job first)
func sjf(newTasks []task) (*task) {

	for i := range(newTasks) {
		queueSFJ = append(queueSFJ, &newTasks[i])
	}

	queueSFJ = triSFJ(queueSFJ)

	if currentSFJ == nil || currentSFJ.Duration <= 0 {
		if len(queueSFJ) > 0 {
			currentSFJ = queueSFJ[0]
			queueSFJ = queueSFJ[1:]
		} else {
			currentSFJ = nil
		}
		
	}

	return currentSFJ
}

func triSFJ(tasks []*task) []*task {

	for i:=0 ; i<len(tasks); i++ {
		for j := 0 ; j<len(tasks) - 1; j++ {
			if (tasks[j].Duration > tasks[j+1].Duration) {
				tasks[j],tasks[j+1] = tasks[j+1], tasks[j]
			}
		}
	}

	return tasks

}
