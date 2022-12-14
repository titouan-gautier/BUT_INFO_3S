package main

var queue []*task
var current *task

// Ordonnanceur premier arrivé premier servi (first come first served)
func fcfs(newTasks []task) (*task) {
	
	for i := range(newTasks) {
		queue = append(queue, &(newTasks[i]))
	}

	if current == nil || current.Duration <= 0 {
		if len(queue) > 0 {
			current = queue[0]
			queue = queue[1:]
		} else {
			current = nil
		}
		
	}
		
	return current
}
