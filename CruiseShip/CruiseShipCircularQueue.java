public class CruiseShipCircularQueue {
    private int size, front, rear;
    private CruiseShipPassenger[] queue = new CruiseShipPassenger[12];  // create variable to queue

    CruiseShipCircularQueue(int size) {   // Declare size of queue
        this.size = size;
        this.front = this.rear = -1;
    }

    public CruiseShipPassenger[] getQueue() {
        return queue;
    }

    public void newQueue(CruiseShipPassenger passenger) {

        if ((front == 0 && rear == size - 1) || (rear == (front - 1) % (size - 1))) {
            System.out.print("Waiting list of cruise ship is Full. Sorry! We cannot add anymore passengers to the waiting list until the cruise ship list is get free .");
        }

        else if (front == -1) {
            front = 0;
            rear = 0;
            queue[rear] = passenger;
        } else if (rear == size - 1 && front != 0) {
            rear = 0;
            queue[rear] = passenger;
        } else {
            rear = (rear + 1);

            if (front <= rear) {
                queue[rear] = passenger;
            }

            else {
                queue[rear] = passenger;
            }
        }
    }

    public CruiseShipPassenger oldQueue() {
        CruiseShipPassenger oldQueuedPassenger;

        if (front == -1) {
            return null;
        }

        oldQueuedPassenger = queue[front];

        if (front == rear) {
            front = -1;
            rear = -1;
        } else if (front == size - 1) {
            front = 0;
        } else {
            front += 1;
        }

        return oldQueuedPassenger;
    }
}
