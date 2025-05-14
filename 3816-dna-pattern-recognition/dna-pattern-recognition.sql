-- Write your PostgreSQL query statement below
SELECT sample_id,
       dna_sequence,
       species,
       dna_sequence ~ '^ATG'           AS has_start,
       dna_sequence ~ 'TAA$|TAG$|TGA$' AS has_stop,
       dna_sequence ~ '.*ATAT.*'       AS has_atat,
       dna_sequence ~ '.*GGG.*'        AS has_ggg
  FROM samples
 ORDER BY sample_id;