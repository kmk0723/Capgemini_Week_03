public class SocialNetwork {
    private UserNode head;

    private static class UserNode {
        String userId;
        String name;
        int age;
        FriendNode friends;
        UserNode next;

        UserNode(String userId, String name, int age) {
            this.userId = userId;
            this.name = name;
            this.age = age;
            this.friends = null;
            this.next = null;
        }
    }

    private static class FriendNode {
        String userId;
        FriendNode next;

        FriendNode(String userId) {
            this.userId = userId;
            this.next = null;
        }
    }

    // Add new user to the network
    public void addUser(String userId, String name, int age) {
        UserNode newNode = new UserNode(userId, name, age);
        if (head == null) {
            head = newNode;
        } else {
            UserNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    // Add friendship between two users
    public void addFriend(String user1, String user2) {
        UserNode u1 = findUser(user1);
        UserNode u2 = findUser(user2);

        if (u1 != null && u2 != null) {
            addFriendToUser(u1, u2.userId);
            addFriendToUser(u2, u1.userId);
        }
    }

    private void addFriendToUser(UserNode user, String friendId) {
        if (!isFriend(user, friendId)) {
            FriendNode newFriend = new FriendNode(friendId);
            if (user.friends == null) {
                user.friends = newFriend;
            } else {
                FriendNode temp = user.friends;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = newFriend;
            }
        }
    }

    // Remove friendship between two users
    public void removeFriend(String user1, String user2) {
        UserNode u1 = findUser(user1);
        UserNode u2 = findUser(user2);

        if (u1 != null && u2 != null) {
            removeFriendFromUser(u1, u2.userId);
            removeFriendFromUser(u2, u1.userId);
        }
    }

    private void removeFriendFromUser(UserNode user, String friendId) {
        FriendNode current = user.friends;
        FriendNode prev = null;

        while (current != null) {
            if (current.userId.equals(friendId)) {
                if (prev == null) {
                    user.friends = current.next;
                } else {
                    prev.next = current.next;
                }
                return;
            }
            prev = current;
            current = current.next;
        }
    }

    // Find mutual friends between two users
    public void findMutualFriends(String user1, String user2) {
        UserNode u1 = findUser(user1);
        UserNode u2 = findUser(user2);

        if (u1 == null || u2 == null) return;

        System.out.println("Mutual friends between " + user1 + " and " + user2 + ":");
        FriendNode current = u1.friends;
        while (current != null) {
            if (isFriend(u2, current.userId)) {
                System.out.println(current.userId);
            }
            current = current.next;
        }
    }

    // Display all friends of a user
    public void displayFriends(String userId) {
        UserNode user = findUser(userId);
        if (user != null) {
            System.out.println("Friends of " + userId + ":");
            FriendNode current = user.friends;
            while (current != null) {
                System.out.println(current.userId);
                current = current.next;
            }
        }
    }

    // Search users by name or ID
    public void searchUser(String query) {
        UserNode current = head;
        System.out.println("Search results for '" + query + "':");
        while (current != null) {
            if (current.userId.equals(query) || current.name.equalsIgnoreCase(query)) {
                System.out.println("ID: " + current.userId + ", Name: " + current.name +
                        ", Age: " + current.age);
            }
            current = current.next;
        }
    }

    // Count friends for a user
    public int countFriends(String userId) {
        UserNode user = findUser(userId);
        int count = 0;
        FriendNode current = user != null ? user.friends : null;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    // Helper methods
    private UserNode findUser(String userId) {
        UserNode current = head;
        while (current != null) {
            if (current.userId.equals(userId)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    private boolean isFriend(UserNode user, String friendId) {
        FriendNode current = user.friends;
        while (current != null) {
            if (current.userId.equals(friendId)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public static void main(String[] args) {
        SocialNetwork network = new SocialNetwork();

        // Add users
        network.addUser("U1", "Alice", 25);
        network.addUser("U2", "Bob", 30);
        network.addUser("U3", "Charlie", 28);

        // Add friendships
        network.addFriend("U1", "U2");
        network.addFriend("U1", "U3");
        network.addFriend("U2", "U3");

        // Display friends
        network.displayFriends("U1");

        // Find mutual friends
        network.findMutualFriends("U1", "U2");

        // Search user
        network.searchUser("Bob");

        // Count friends
        System.out.println("Friend count for U1: " + network.countFriends("U1"));

        // Remove friendship
        network.removeFriend("U1", "U2");
        network.displayFriends("U1");
    }
}
