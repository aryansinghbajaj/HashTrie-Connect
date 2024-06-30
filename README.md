<!-- Main Title -->
<h1 style="font-size:36px; color:#333;">HashTrie-Connect</h1>

<!-- Section Overview -->
<h2 style="font-size:28px; color:#444;">Overview</h2>
<p style="font-size:18px; color:#555;">
Hash Trie Connect is a Java-based application designed to efficiently manage a phone book directory using Trie and HashMap data structures. This project combines the strengths of these data structures to enable quick and effective contact management and search functionalities.
</p>

<!-- Section Core Features -->
<h2 style="font-size:28px; color:#444;">Core Features</h2>

<!-- Subsection Adding Contacts -->
<h3 style="font-size:24px; color:#666;">Adding Contacts</h3>
<p style="font-size:18px; color:#555;">
Users can add new contacts to the directory with a name and phone number. The contact names are stored in a Trie, a tree-like data structure, to facilitate efficient prefix-based searching. Phone numbers are stored in a HashMap, mapping each contact name to its corresponding phone number for quick retrieval.
</p>

<!-- Subsection Searching by Prefix -->
<h3 style="font-size:24px; color:#666;">Searching by Prefix</h3>
<p style="font-size:18px; color:#555;">
Users can search for contacts by entering a prefix of the contact name. The Trie structure allows rapid identification of all contact names that start with the given prefix. For each matching contact, the corresponding phone number is fetched from the HashMap and displayed.
</p>

<!-- Subsection Identifying Callers -->
<h3 style="font-size:24px; color:#666;">Identifying Callers</h3>
<p style="font-size:18px; color:#555;">
By using <code>getKeyByValue()</code> function, users can identify which contact is calling. This feature leverages the HashMap to directly map phone numbers to their respective contact names, providing immediate results.
</p>
