package main

var queueSRT []*task
var currentSRT *task

// Ordonnanceur selon la durée de calcul restante (shortest remaining time)
func srt(newTasks []task) (*task) {

	for i := range(newTasks) {
		queueSRT = append(queueSRT, &newTasks[i])
	}

	queueSRT = triSRT(queueSRT)

	if len(queueSRT) > 0 {
		currentSRT = queueSRT[0]
		if currentSRT.Duration <= 0 {
			queueSRT = queueSRT[1:]
			if len(queueSRT) > 0 {
				currentSRT = queueSRT[0]
			} else {
				currentSRT = nil
			}
			
		}
	} else {
		currentSRT = nil
	}

	return currentSRT
}


func triSRT(tasks []*task) []*task {

	for i:=0 ; i<len(tasks); i++ {
		for j := 0 ; j<len(tasks) - 1; j++ {
			if (tasks[j].Duration > tasks[j+1].Duration) {
				tasks[j],tasks[j+1] = tasks[j+1], tasks[j]
			}
		}
	}

	return tasks

}
