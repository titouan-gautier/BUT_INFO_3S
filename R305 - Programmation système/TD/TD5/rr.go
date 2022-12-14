package main
// Ordonnanceur à temps partagé avec politique du tourniquet (Round Robin)
// le quantum vaudra 5 unités de temps

var currentRR *task
var queueRR []*task
var quantumRR int = 0
var pos int

func rr(newTasks []task) (*task) {

	for i := range(newTasks) {
		queueRR = append(queueRR, &newTasks[i])
	}

	if currentRR != nil &&  currentRR.Duration <= 0 {
		queueRR = remove(queueRR,pos)

		if len(queueRR) > 0 {
			currentRR = queueRR[pos]
		} else {
			currentRR = nil
		}

		quantumRR = 5
	}

	if quantumRR <= 0 {
		if pos < len(queueRR) - 1 {
			pos++
		} else {
			pos = 0
		}
		
		if len(queueRR) > 0 {
			currentRR = queueRR[pos]
		} else {
			currentRR = nil
		}

		quantumRR = 5
	}

	quantumRR--

	return currentRR

}



func remove(slice []*task, s int) []*task {
    return append(slice[:s], slice[s+1:]...)
}
