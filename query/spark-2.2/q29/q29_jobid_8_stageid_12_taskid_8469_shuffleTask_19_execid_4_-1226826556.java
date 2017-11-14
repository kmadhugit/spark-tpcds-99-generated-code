/* 001 */ public Object generate(Object[] references) {
/* 002 */   return new GeneratedIterator(references);
/* 003 */ }
/* 004 */
/* 005 */ final class GeneratedIterator extends org.apache.spark.sql.execution.BufferedRowIterator {
/* 006 */   private Object[] references;
/* 007 */   private scala.collection.Iterator[] inputs;
/* 008 */   private boolean agg_initAgg;
/* 009 */   private boolean agg_bufIsNull;
/* 010 */   private long agg_bufValue;
/* 011 */   private boolean agg_bufIsNull1;
/* 012 */   private long agg_bufValue1;
/* 013 */   private boolean agg_bufIsNull2;
/* 014 */   private long agg_bufValue2;
/* 015 */   private org.apache.spark.sql.execution.aggregate.HashAggregateExec agg_plan;
/* 016 */   private agg_FastHashMap agg_fastHashMap;
/* 017 */   private org.apache.spark.unsafe.KVIterator agg_fastHashMapIter;
/* 018 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap;
/* 019 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter;
/* 020 */   private org.apache.spark.unsafe.KVIterator agg_mapIter;
/* 021 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory;
/* 022 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize;
/* 023 */   private scala.collection.Iterator smj_leftInput;
/* 024 */   private scala.collection.Iterator smj_rightInput;
/* 025 */   private InternalRow smj_leftRow;
/* 026 */   private InternalRow smj_rightRow;
/* 027 */   private long smj_value6;
/* 028 */   private long smj_value7;
/* 029 */   private org.apache.spark.sql.execution.ExternalAppendOnlyUnsafeRowArray smj_matches;
/* 030 */   private long smj_value8;
/* 031 */   private long smj_value9;
/* 032 */   private int smj_value10;
/* 033 */   private boolean smj_isNull6;
/* 034 */   private int smj_value11;
/* 035 */   private boolean smj_isNull7;
/* 036 */   private int smj_value12;
/* 037 */   private boolean smj_isNull8;
/* 038 */   private int smj_value13;
/* 039 */   private boolean smj_isNull9;
/* 040 */   private long smj_value14;
/* 041 */   private boolean smj_isNull10;
/* 042 */   private long smj_value15;
/* 043 */   private boolean smj_isNull11;
/* 044 */   private long smj_value16;
/* 045 */   private boolean smj_isNull12;
/* 046 */   private int smj_value17;
/* 047 */   private boolean smj_isNull13;
/* 048 */   private org.apache.spark.sql.execution.metric.SQLMetric smj_numOutputRows;
/* 049 */   private UnsafeRow smj_result;
/* 050 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder smj_holder;
/* 051 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter smj_rowWriter;
/* 052 */   private UnsafeRow project_result;
/* 053 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 054 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 055 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast;
/* 056 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation;
/* 057 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows;
/* 058 */   private UnsafeRow bhj_result;
/* 059 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder;
/* 060 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter;
/* 061 */   private UnsafeRow project_result1;
/* 062 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder1;
/* 063 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter1;
/* 064 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast1;
/* 065 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation1;
/* 066 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows1;
/* 067 */   private UnsafeRow bhj_result1;
/* 068 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder1;
/* 069 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter1;
/* 070 */   private UnsafeRow project_result2;
/* 071 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder2;
/* 072 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter2;
/* 073 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast2;
/* 074 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation2;
/* 075 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows2;
/* 076 */   private UnsafeRow bhj_result2;
/* 077 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder2;
/* 078 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter2;
/* 079 */   private UnsafeRow project_result3;
/* 080 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder3;
/* 081 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter3;
/* 082 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast3;
/* 083 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation3;
/* 084 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows3;
/* 085 */   private UnsafeRow bhj_result3;
/* 086 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder3;
/* 087 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter3;
/* 088 */   private UnsafeRow project_result4;
/* 089 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder4;
/* 090 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter4;
/* 091 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast4;
/* 092 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation4;
/* 093 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows4;
/* 094 */   private UnsafeRow bhj_result4;
/* 095 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder4;
/* 096 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter4;
/* 097 */   private UnsafeRow project_result5;
/* 098 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder5;
/* 099 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter5;
/* 100 */   private UnsafeRow agg_result4;
/* 101 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 102 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 103 */   private int agg_value14;
/* 104 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowJoiner agg_unsafeRowJoiner;
/* 105 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 106 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 107 */
/* 108 */   public GeneratedIterator(Object[] references) {
/* 109 */     this.references = references;
/* 110 */   }
/* 111 */
/* 112 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 113 */     partitionIndex = index;
/* 114 */     this.inputs = inputs;
/* 115 */     wholestagecodegen_init_0();
/* 116 */     wholestagecodegen_init_1();
/* 117 */     wholestagecodegen_init_2();
/* 118 */     wholestagecodegen_init_3();
/* 119 */     wholestagecodegen_init_4();
/* 120 */     wholestagecodegen_init_5();
/* 121 */
/* 122 */   }
/* 123 */
/* 124 */   private void wholestagecodegen_init_0() {
/* 125 */     agg_initAgg = false;
/* 126 */
/* 127 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 128 */     agg_fastHashMap = new agg_FastHashMap(agg_plan.getTaskMemoryManager(), agg_plan.getEmptyAggregationBuffer());
/* 129 */
/* 130 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 131 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 132 */     smj_leftInput = inputs[0];
/* 133 */     smj_rightInput = inputs[1];
/* 134 */
/* 135 */     smj_rightRow = null;
/* 136 */
/* 137 */     smj_matches = new org.apache.spark.sql.execution.ExternalAppendOnlyUnsafeRowArray(2147483647);
/* 138 */
/* 139 */     this.smj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[10];
/* 140 */     smj_result = new UnsafeRow(12);
/* 141 */     this.smj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(smj_result, 0);
/* 142 */     this.smj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(smj_holder, 12);
/* 143 */     project_result = new UnsafeRow(8);
/* 144 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 145 */
/* 146 */   }
/* 147 */
/* 148 */   private void wholestagecodegen_init_3() {
/* 149 */     this.bhj_numOutputRows2 = (org.apache.spark.sql.execution.metric.SQLMetric) references[16];
/* 150 */     bhj_result2 = new UnsafeRow(7);
/* 151 */     this.bhj_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result2, 0);
/* 152 */     this.bhj_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder2, 7);
/* 153 */     project_result3 = new UnsafeRow(5);
/* 154 */     this.project_holder3 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result3, 0);
/* 155 */     this.project_rowWriter3 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder3, 5);
/* 156 */     this.bhj_broadcast3 = (org.apache.spark.broadcast.TorrentBroadcast) references[17];
/* 157 */
/* 158 */     bhj_relation3 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast3.value()).asReadOnlyCopy();
/* 159 */     incPeakExecutionMemory(bhj_relation3.estimatedSize());
/* 160 */
/* 161 */     this.bhj_numOutputRows3 = (org.apache.spark.sql.execution.metric.SQLMetric) references[18];
/* 162 */     bhj_result3 = new UnsafeRow(8);
/* 163 */     this.bhj_holder3 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result3, 64);
/* 164 */
/* 165 */   }
/* 166 */
/* 167 */   public class agg_FastHashMap {
/* 168 */     private org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch batch;
/* 169 */     private int[] buckets;
/* 170 */     private int capacity = 1 << 16;
/* 171 */     private double loadFactor = 0.5;
/* 172 */     private int numBuckets = (int) (capacity / loadFactor);
/* 173 */     private int maxSteps = 2;
/* 174 */     private int numRows = 0;
/* 175 */     private org.apache.spark.sql.types.StructType keySchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[3])", org.apache.spark.sql.types.DataTypes.StringType)
/* 176 */     .add("((java.lang.String) references[4])", org.apache.spark.sql.types.DataTypes.StringType)
/* 177 */     .add("((java.lang.String) references[5])", org.apache.spark.sql.types.DataTypes.StringType)
/* 178 */     .add("((java.lang.String) references[6])", org.apache.spark.sql.types.DataTypes.StringType);
/* 179 */     private org.apache.spark.sql.types.StructType valueSchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[7])", org.apache.spark.sql.types.DataTypes.LongType)
/* 180 */     .add("((java.lang.String) references[8])", org.apache.spark.sql.types.DataTypes.LongType)
/* 181 */     .add("((java.lang.String) references[9])", org.apache.spark.sql.types.DataTypes.LongType);
/* 182 */     private Object emptyVBase;
/* 183 */     private long emptyVOff;
/* 184 */     private int emptyVLen;
/* 185 */     private boolean isBatchFull = false;
/* 186 */
/* 187 */     public agg_FastHashMap(
/* 188 */       org.apache.spark.memory.TaskMemoryManager taskMemoryManager,
/* 189 */       InternalRow emptyAggregationBuffer) {
/* 190 */       batch = org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch
/* 191 */       .allocate(keySchema, valueSchema, taskMemoryManager, capacity);
/* 192 */
/* 193 */       final UnsafeProjection valueProjection = UnsafeProjection.create(valueSchema);
/* 194 */       final byte[] emptyBuffer = valueProjection.apply(emptyAggregationBuffer).getBytes();
/* 195 */
/* 196 */       emptyVBase = emptyBuffer;
/* 197 */       emptyVOff = Platform.BYTE_ARRAY_OFFSET;
/* 198 */       emptyVLen = emptyBuffer.length;
/* 199 */
/* 200 */       buckets = new int[numBuckets];
/* 201 */       java.util.Arrays.fill(buckets, -1);
/* 202 */     }
/* 203 */
/* 204 */     public org.apache.spark.sql.catalyst.expressions.UnsafeRow findOrInsert(UTF8String agg_key, UTF8String agg_key1, UTF8String agg_key2, UTF8String agg_key3) {
/* 205 */       long h = hash(agg_key, agg_key1, agg_key2, agg_key3);
/* 206 */       int step = 0;
/* 207 */       int idx = (int) h & (numBuckets - 1);
/* 208 */       while (step < maxSteps) {
/* 209 */         // Return bucket index if it's either an empty slot or already contains the key
/* 210 */         if (buckets[idx] == -1) {
/* 211 */           if (numRows < capacity && !isBatchFull) {
/* 212 */             // creating the unsafe for new entry
/* 213 */             UnsafeRow agg_result = new UnsafeRow(4);
/* 214 */             org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder
/* 215 */             = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result,
/* 216 */               128);
/* 217 */             org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter
/* 218 */             = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(
/* 219 */               agg_holder,
/* 220 */               4);
/* 221 */             agg_holder.reset(); //TODO: investigate if reset or zeroout are actually needed
/* 222 */             agg_rowWriter.zeroOutNullBytes();
/* 223 */             agg_rowWriter.write(0, agg_key);
/* 224 */             agg_rowWriter.write(1, agg_key1);
/* 225 */             agg_rowWriter.write(2, agg_key2);
/* 226 */             agg_rowWriter.write(3, agg_key3);
/* 227 */             agg_result.setTotalSize(agg_holder.totalSize());
/* 228 */             Object kbase = agg_result.getBaseObject();
/* 229 */             long koff = agg_result.getBaseOffset();
/* 230 */             int klen = agg_result.getSizeInBytes();
/* 231 */
/* 232 */             UnsafeRow vRow
/* 233 */             = batch.appendRow(kbase, koff, klen, emptyVBase, emptyVOff, emptyVLen);
/* 234 */             if (vRow == null) {
/* 235 */               isBatchFull = true;
/* 236 */             } else {
/* 237 */               buckets[idx] = numRows++;
/* 238 */             }
/* 239 */             return vRow;
/* 240 */           } else {
/* 241 */             // No more space
/* 242 */             return null;
/* 243 */           }
/* 244 */         } else if (equals(idx, agg_key, agg_key1, agg_key2, agg_key3)) {
/* 245 */           return batch.getValueRow(buckets[idx]);
/* 246 */         }
/* 247 */         idx = (idx + 1) & (numBuckets - 1);
/* 248 */         step++;
/* 249 */       }
/* 250 */       // Didn't find it
/* 251 */       return null;
/* 252 */     }
/* 253 */
/* 254 */     private boolean equals(int idx, UTF8String agg_key, UTF8String agg_key1, UTF8String agg_key2, UTF8String agg_key3) {
/* 255 */       UnsafeRow row = batch.getKeyRow(buckets[idx]);
/* 256 */       return (row.getUTF8String(0).equals(agg_key)) && (row.getUTF8String(1).equals(agg_key1)) && (row.getUTF8String(2).equals(agg_key2)) && (row.getUTF8String(3).equals(agg_key3));
/* 257 */     }
/* 258 */
/* 259 */     private long hash(UTF8String agg_key, UTF8String agg_key1, UTF8String agg_key2, UTF8String agg_key3) {
/* 260 */       long agg_hash = 0;
/* 261 */
/* 262 */       int agg_result = 0;
/* 263 */       byte[] agg_bytes = agg_key.getBytes();
/* 264 */       for (int i = 0; i < agg_bytes.length; i++) {
/* 265 */         int agg_hash1 = agg_bytes[i];
/* 266 */         agg_result = (agg_result ^ (0x9e3779b9)) + agg_hash1 + (agg_result << 6) + (agg_result >>> 2);
/* 267 */       }
/* 268 */
/* 269 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result + (agg_hash << 6) + (agg_hash >>> 2);
/* 270 */
/* 271 */       int agg_result1 = 0;
/* 272 */       byte[] agg_bytes1 = agg_key1.getBytes();
/* 273 */       for (int i = 0; i < agg_bytes1.length; i++) {
/* 274 */         int agg_hash2 = agg_bytes1[i];
/* 275 */         agg_result1 = (agg_result1 ^ (0x9e3779b9)) + agg_hash2 + (agg_result1 << 6) + (agg_result1 >>> 2);
/* 276 */       }
/* 277 */
/* 278 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result1 + (agg_hash << 6) + (agg_hash >>> 2);
/* 279 */
/* 280 */       int agg_result2 = 0;
/* 281 */       byte[] agg_bytes2 = agg_key2.getBytes();
/* 282 */       for (int i = 0; i < agg_bytes2.length; i++) {
/* 283 */         int agg_hash3 = agg_bytes2[i];
/* 284 */         agg_result2 = (agg_result2 ^ (0x9e3779b9)) + agg_hash3 + (agg_result2 << 6) + (agg_result2 >>> 2);
/* 285 */       }
/* 286 */
/* 287 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result2 + (agg_hash << 6) + (agg_hash >>> 2);
/* 288 */
/* 289 */       int agg_result3 = 0;
/* 290 */       byte[] agg_bytes3 = agg_key3.getBytes();
/* 291 */       for (int i = 0; i < agg_bytes3.length; i++) {
/* 292 */         int agg_hash4 = agg_bytes3[i];
/* 293 */         agg_result3 = (agg_result3 ^ (0x9e3779b9)) + agg_hash4 + (agg_result3 << 6) + (agg_result3 >>> 2);
/* 294 */       }
/* 295 */
/* 296 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result3 + (agg_hash << 6) + (agg_hash >>> 2);
/* 297 */
/* 298 */       return agg_hash;
/* 299 */     }
/* 300 */
/* 301 */     public org.apache.spark.unsafe.KVIterator<UnsafeRow, UnsafeRow> rowIterator() {
/* 302 */       return batch.rowIterator();
/* 303 */     }
/* 304 */
/* 305 */     public void close() {
/* 306 */       batch.close();
/* 307 */     }
/* 308 */
/* 309 */   }
/* 310 */
/* 311 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 312 */     agg_hashMap = agg_plan.createHashMap();
/* 313 */
/* 314 */     while (findNextInnerJoinRows(smj_leftInput, smj_rightInput)) {
/* 315 */       smj_isNull6 = smj_leftRow.isNullAt(0);
/* 316 */       smj_value10 = smj_isNull6 ? -1 : (smj_leftRow.getInt(0));
/* 317 */       smj_isNull7 = smj_leftRow.isNullAt(1);
/* 318 */       smj_value11 = smj_isNull7 ? -1 : (smj_leftRow.getInt(1));
/* 319 */       smj_isNull8 = smj_leftRow.isNullAt(2);
/* 320 */       smj_value12 = smj_isNull8 ? -1 : (smj_leftRow.getInt(2));
/* 321 */       smj_isNull9 = smj_leftRow.isNullAt(3);
/* 322 */       smj_value13 = smj_isNull9 ? -1 : (smj_leftRow.getInt(3));
/* 323 */       smj_isNull10 = smj_leftRow.isNullAt(4);
/* 324 */       smj_value14 = smj_isNull10 ? -1L : (smj_leftRow.getLong(4));
/* 325 */       smj_isNull11 = smj_leftRow.isNullAt(5);
/* 326 */       smj_value15 = smj_isNull11 ? -1L : (smj_leftRow.getLong(5));
/* 327 */       smj_isNull12 = smj_leftRow.isNullAt(6);
/* 328 */       smj_value16 = smj_isNull12 ? -1L : (smj_leftRow.getLong(6));
/* 329 */       smj_isNull13 = smj_leftRow.isNullAt(7);
/* 330 */       smj_value17 = smj_isNull13 ? -1 : (smj_leftRow.getInt(7));
/* 331 */       scala.collection.Iterator<UnsafeRow> smj_iterator = smj_matches.generateIterator();
/* 332 */       while (smj_iterator.hasNext()) {
/* 333 */         InternalRow smj_rightRow1 = (InternalRow) smj_iterator.next();
/* 334 */
/* 335 */         smj_numOutputRows.add(1);
/* 336 */
/* 337 */         // generate join key for stream side
/* 338 */
/* 339 */         boolean bhj_isNull = smj_isNull9;
/* 340 */         long bhj_value = -1L;
/* 341 */         if (!smj_isNull9) {
/* 342 */           bhj_value = (long) smj_value13;
/* 343 */         }
/* 344 */         // find matches from HashedRelation
/* 345 */         UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 346 */         if (bhj_matched == null) continue;
/* 347 */
/* 348 */         bhj_numOutputRows.add(1);
/* 349 */
/* 350 */         // generate join key for stream side
/* 351 */
/* 352 */         boolean bhj_isNull12 = smj_isNull13;
/* 353 */         long bhj_value12 = -1L;
/* 354 */         if (!smj_isNull13) {
/* 355 */           bhj_value12 = (long) smj_value17;
/* 356 */         }
/* 357 */         // find matches from HashedRelation
/* 358 */         UnsafeRow bhj_matched1 = bhj_isNull12 ? null: (UnsafeRow)bhj_relation1.getValue(bhj_value12);
/* 359 */         if (bhj_matched1 == null) continue;
/* 360 */
/* 361 */         bhj_numOutputRows1.add(1);
/* 362 */
/* 363 */         boolean smj_isNull17 = smj_rightRow1.isNullAt(3);
/* 364 */         int smj_value21 = smj_isNull17 ? -1 : (smj_rightRow1.getInt(3));
/* 365 */
/* 366 */         // generate join key for stream side
/* 367 */
/* 368 */         boolean bhj_isNull23 = smj_isNull17;
/* 369 */         long bhj_value23 = -1L;
/* 370 */         if (!smj_isNull17) {
/* 371 */           bhj_value23 = (long) smj_value21;
/* 372 */         }
/* 373 */         // find matches from HashedRelation
/* 374 */         UnsafeRow bhj_matched2 = bhj_isNull23 ? null: (UnsafeRow)bhj_relation2.getValue(bhj_value23);
/* 375 */         if (bhj_matched2 == null) continue;
/* 376 */
/* 377 */         bhj_numOutputRows2.add(1);
/* 378 */
/* 379 */         // generate join key for stream side
/* 380 */
/* 381 */         boolean bhj_isNull33 = smj_isNull7;
/* 382 */         long bhj_value33 = -1L;
/* 383 */         if (!smj_isNull7) {
/* 384 */           bhj_value33 = (long) smj_value11;
/* 385 */         }
/* 386 */         // find matches from HashedRelation
/* 387 */         UnsafeRow bhj_matched3 = bhj_isNull33 ? null: (UnsafeRow)bhj_relation3.getValue(bhj_value33);
/* 388 */         if (bhj_matched3 == null) continue;
/* 389 */
/* 390 */         bhj_numOutputRows3.add(1);
/* 391 */
/* 392 */         // generate join key for stream side
/* 393 */
/* 394 */         boolean bhj_isNull46 = smj_isNull6;
/* 395 */         long bhj_value46 = -1L;
/* 396 */         if (!smj_isNull6) {
/* 397 */           bhj_value46 = (long) smj_value10;
/* 398 */         }
/* 399 */         // find matches from HashedRelation
/* 400 */         UnsafeRow bhj_matched4 = bhj_isNull46 ? null: (UnsafeRow)bhj_relation4.getValue(bhj_value46);
/* 401 */         if (bhj_matched4 == null) continue;
/* 402 */
/* 403 */         bhj_numOutputRows4.add(1);
/* 404 */
/* 405 */         boolean smj_isNull16 = smj_rightRow1.isNullAt(2);
/* 406 */         int smj_value20 = smj_isNull16 ? -1 : (smj_rightRow1.getInt(2));
/* 407 */         boolean bhj_isNull36 = bhj_matched3.isNullAt(1);
/* 408 */         UTF8String bhj_value36 = bhj_isNull36 ? null : (bhj_matched3.getUTF8String(1));
/* 409 */         boolean bhj_isNull37 = bhj_matched3.isNullAt(2);
/* 410 */         UTF8String bhj_value37 = bhj_isNull37 ? null : (bhj_matched3.getUTF8String(2));
/* 411 */         boolean bhj_isNull49 = bhj_matched4.isNullAt(1);
/* 412 */         UTF8String bhj_value49 = bhj_isNull49 ? null : (bhj_matched4.getUTF8String(1));
/* 413 */         boolean bhj_isNull50 = bhj_matched4.isNullAt(2);
/* 414 */         UTF8String bhj_value50 = bhj_isNull50 ? null : (bhj_matched4.getUTF8String(2));
/* 415 */
/* 416 */         UnsafeRow agg_unsafeRowAggBuffer = null;
/* 417 */
/* 418 */         UnsafeRow agg_fastAggBuffer = null;
/* 419 */
/* 420 */         if (true) {
/* 421 */           if (!bhj_isNull49 && !bhj_isNull50 && !bhj_isNull36 && !bhj_isNull37) {
/* 422 */             agg_fastAggBuffer = agg_fastHashMap.findOrInsert(
/* 423 */               bhj_value49, bhj_value50, bhj_value36, bhj_value37);
/* 424 */           }
/* 425 */         }
/* 426 */
/* 427 */         if (agg_fastAggBuffer == null) {
/* 428 */           // generate grouping key
/* 429 */           agg_holder.reset();
/* 430 */
/* 431 */           agg_rowWriter.zeroOutNullBytes();
/* 432 */
/* 433 */           if (bhj_isNull49) {
/* 434 */             agg_rowWriter.setNullAt(0);
/* 435 */           } else {
/* 436 */             agg_rowWriter.write(0, bhj_value49);
/* 437 */           }
/* 438 */
/* 439 */           if (bhj_isNull50) {
/* 440 */             agg_rowWriter.setNullAt(1);
/* 441 */           } else {
/* 442 */             agg_rowWriter.write(1, bhj_value50);
/* 443 */           }
/* 444 */
/* 445 */           if (bhj_isNull36) {
/* 446 */             agg_rowWriter.setNullAt(2);
/* 447 */           } else {
/* 448 */             agg_rowWriter.write(2, bhj_value36);
/* 449 */           }
/* 450 */
/* 451 */           if (bhj_isNull37) {
/* 452 */             agg_rowWriter.setNullAt(3);
/* 453 */           } else {
/* 454 */             agg_rowWriter.write(3, bhj_value37);
/* 455 */           }
/* 456 */           agg_result4.setTotalSize(agg_holder.totalSize());
/* 457 */           agg_value14 = 42;
/* 458 */
/* 459 */           if (!bhj_isNull49) {
/* 460 */             agg_value14 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value49.getBaseObject(), bhj_value49.getBaseOffset(), bhj_value49.numBytes(), agg_value14);
/* 461 */           }
/* 462 */
/* 463 */           if (!bhj_isNull50) {
/* 464 */             agg_value14 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value50.getBaseObject(), bhj_value50.getBaseOffset(), bhj_value50.numBytes(), agg_value14);
/* 465 */           }
/* 466 */
/* 467 */           if (!bhj_isNull36) {
/* 468 */             agg_value14 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value36.getBaseObject(), bhj_value36.getBaseOffset(), bhj_value36.numBytes(), agg_value14);
/* 469 */           }
/* 470 */
/* 471 */           if (!bhj_isNull37) {
/* 472 */             agg_value14 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value37.getBaseObject(), bhj_value37.getBaseOffset(), bhj_value37.numBytes(), agg_value14);
/* 473 */           }
/* 474 */           if (true) {
/* 475 */             // try to get the buffer from hash map
/* 476 */             agg_unsafeRowAggBuffer =
/* 477 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result4, agg_value14);
/* 478 */           }
/* 479 */           if (agg_unsafeRowAggBuffer == null) {
/* 480 */             if (agg_sorter == null) {
/* 481 */               agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 482 */             } else {
/* 483 */               agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 484 */             }
/* 485 */
/* 486 */             // the hash map had be spilled, it should have enough memory now,
/* 487 */             // try  to allocate buffer again.
/* 488 */             agg_unsafeRowAggBuffer =
/* 489 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result4, agg_value14);
/* 490 */             if (agg_unsafeRowAggBuffer == null) {
/* 491 */               // failed to allocate the first page
/* 492 */               throw new OutOfMemoryError("No enough memory for aggregation");
/* 493 */             }
/* 494 */           }
/* 495 */         }
/* 496 */
/* 497 */         if (agg_fastAggBuffer != null) {
/* 498 */           // update fast row
/* 499 */
/* 500 */           // common sub-expressions
/* 501 */
/* 502 */           // evaluate aggregate function
/* 503 */           boolean agg_isNull43 = true;
/* 504 */           long agg_value46 = -1L;
/* 505 */
/* 506 */           boolean agg_isNull45 = agg_fastAggBuffer.isNullAt(0);
/* 507 */           long agg_value48 = agg_isNull45 ? -1L : (agg_fastAggBuffer.getLong(0));
/* 508 */           boolean agg_isNull44 = agg_isNull45;
/* 509 */           long agg_value47 = agg_value48;
/* 510 */           if (agg_isNull44) {
/* 511 */             boolean agg_isNull46 = false;
/* 512 */             long agg_value49 = -1L;
/* 513 */             if (!false) {
/* 514 */               agg_value49 = (long) 0;
/* 515 */             }
/* 516 */             if (!agg_isNull46) {
/* 517 */               agg_isNull44 = false;
/* 518 */               agg_value47 = agg_value49;
/* 519 */             }
/* 520 */           }
/* 521 */
/* 522 */           boolean agg_isNull48 = smj_isNull8;
/* 523 */           long agg_value51 = -1L;
/* 524 */           if (!smj_isNull8) {
/* 525 */             agg_value51 = (long) smj_value12;
/* 526 */           }
/* 527 */           if (!agg_isNull48) {
/* 528 */             agg_isNull43 = false; // resultCode could change nullability.
/* 529 */             agg_value46 = agg_value47 + agg_value51;
/* 530 */
/* 531 */           }
/* 532 */           boolean agg_isNull42 = agg_isNull43;
/* 533 */           long agg_value45 = agg_value46;
/* 534 */           if (agg_isNull42) {
/* 535 */             boolean agg_isNull50 = agg_fastAggBuffer.isNullAt(0);
/* 536 */             long agg_value53 = agg_isNull50 ? -1L : (agg_fastAggBuffer.getLong(0));
/* 537 */             if (!agg_isNull50) {
/* 538 */               agg_isNull42 = false;
/* 539 */               agg_value45 = agg_value53;
/* 540 */             }
/* 541 */           }
/* 542 */           boolean agg_isNull52 = true;
/* 543 */           long agg_value55 = -1L;
/* 544 */
/* 545 */           boolean agg_isNull54 = agg_fastAggBuffer.isNullAt(1);
/* 546 */           long agg_value57 = agg_isNull54 ? -1L : (agg_fastAggBuffer.getLong(1));
/* 547 */           boolean agg_isNull53 = agg_isNull54;
/* 548 */           long agg_value56 = agg_value57;
/* 549 */           if (agg_isNull53) {
/* 550 */             boolean agg_isNull55 = false;
/* 551 */             long agg_value58 = -1L;
/* 552 */             if (!false) {
/* 553 */               agg_value58 = (long) 0;
/* 554 */             }
/* 555 */             if (!agg_isNull55) {
/* 556 */               agg_isNull53 = false;
/* 557 */               agg_value56 = agg_value58;
/* 558 */             }
/* 559 */           }
/* 560 */
/* 561 */           if (!smj_isNull12) {
/* 562 */             agg_isNull52 = false; // resultCode could change nullability.
/* 563 */             agg_value55 = agg_value56 + smj_value16;
/* 564 */
/* 565 */           }
/* 566 */           boolean agg_isNull51 = agg_isNull52;
/* 567 */           long agg_value54 = agg_value55;
/* 568 */           if (agg_isNull51) {
/* 569 */             boolean agg_isNull58 = agg_fastAggBuffer.isNullAt(1);
/* 570 */             long agg_value61 = agg_isNull58 ? -1L : (agg_fastAggBuffer.getLong(1));
/* 571 */             if (!agg_isNull58) {
/* 572 */               agg_isNull51 = false;
/* 573 */               agg_value54 = agg_value61;
/* 574 */             }
/* 575 */           }
/* 576 */           boolean agg_isNull60 = true;
/* 577 */           long agg_value63 = -1L;
/* 578 */
/* 579 */           boolean agg_isNull62 = agg_fastAggBuffer.isNullAt(2);
/* 580 */           long agg_value65 = agg_isNull62 ? -1L : (agg_fastAggBuffer.getLong(2));
/* 581 */           boolean agg_isNull61 = agg_isNull62;
/* 582 */           long agg_value64 = agg_value65;
/* 583 */           if (agg_isNull61) {
/* 584 */             boolean agg_isNull63 = false;
/* 585 */             long agg_value66 = -1L;
/* 586 */             if (!false) {
/* 587 */               agg_value66 = (long) 0;
/* 588 */             }
/* 589 */             if (!agg_isNull63) {
/* 590 */               agg_isNull61 = false;
/* 591 */               agg_value64 = agg_value66;
/* 592 */             }
/* 593 */           }
/* 594 */
/* 595 */           boolean agg_isNull65 = smj_isNull16;
/* 596 */           long agg_value68 = -1L;
/* 597 */           if (!smj_isNull16) {
/* 598 */             agg_value68 = (long) smj_value20;
/* 599 */           }
/* 600 */           if (!agg_isNull65) {
/* 601 */             agg_isNull60 = false; // resultCode could change nullability.
/* 602 */             agg_value63 = agg_value64 + agg_value68;
/* 603 */
/* 604 */           }
/* 605 */           boolean agg_isNull59 = agg_isNull60;
/* 606 */           long agg_value62 = agg_value63;
/* 607 */           if (agg_isNull59) {
/* 608 */             boolean agg_isNull67 = agg_fastAggBuffer.isNullAt(2);
/* 609 */             long agg_value70 = agg_isNull67 ? -1L : (agg_fastAggBuffer.getLong(2));
/* 610 */             if (!agg_isNull67) {
/* 611 */               agg_isNull59 = false;
/* 612 */               agg_value62 = agg_value70;
/* 613 */             }
/* 614 */           }
/* 615 */           // update fast row
/* 616 */           if (!agg_isNull42) {
/* 617 */             agg_fastAggBuffer.setLong(0, agg_value45);
/* 618 */           } else {
/* 619 */             agg_fastAggBuffer.setNullAt(0);
/* 620 */           }
/* 621 */
/* 622 */           if (!agg_isNull51) {
/* 623 */             agg_fastAggBuffer.setLong(1, agg_value54);
/* 624 */           } else {
/* 625 */             agg_fastAggBuffer.setNullAt(1);
/* 626 */           }
/* 627 */
/* 628 */           if (!agg_isNull59) {
/* 629 */             agg_fastAggBuffer.setLong(2, agg_value62);
/* 630 */           } else {
/* 631 */             agg_fastAggBuffer.setNullAt(2);
/* 632 */           }
/* 633 */
/* 634 */         } else {
/* 635 */           // update unsafe row
/* 636 */
/* 637 */           // common sub-expressions
/* 638 */
/* 639 */           // evaluate aggregate function
/* 640 */           boolean agg_isNull17 = true;
/* 641 */           long agg_value20 = -1L;
/* 642 */
/* 643 */           boolean agg_isNull19 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 644 */           long agg_value22 = agg_isNull19 ? -1L : (agg_unsafeRowAggBuffer.getLong(0));
/* 645 */           boolean agg_isNull18 = agg_isNull19;
/* 646 */           long agg_value21 = agg_value22;
/* 647 */           if (agg_isNull18) {
/* 648 */             boolean agg_isNull20 = false;
/* 649 */             long agg_value23 = -1L;
/* 650 */             if (!false) {
/* 651 */               agg_value23 = (long) 0;
/* 652 */             }
/* 653 */             if (!agg_isNull20) {
/* 654 */               agg_isNull18 = false;
/* 655 */               agg_value21 = agg_value23;
/* 656 */             }
/* 657 */           }
/* 658 */
/* 659 */           boolean agg_isNull22 = smj_isNull8;
/* 660 */           long agg_value25 = -1L;
/* 661 */           if (!smj_isNull8) {
/* 662 */             agg_value25 = (long) smj_value12;
/* 663 */           }
/* 664 */           if (!agg_isNull22) {
/* 665 */             agg_isNull17 = false; // resultCode could change nullability.
/* 666 */             agg_value20 = agg_value21 + agg_value25;
/* 667 */
/* 668 */           }
/* 669 */           boolean agg_isNull16 = agg_isNull17;
/* 670 */           long agg_value19 = agg_value20;
/* 671 */           if (agg_isNull16) {
/* 672 */             boolean agg_isNull24 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 673 */             long agg_value27 = agg_isNull24 ? -1L : (agg_unsafeRowAggBuffer.getLong(0));
/* 674 */             if (!agg_isNull24) {
/* 675 */               agg_isNull16 = false;
/* 676 */               agg_value19 = agg_value27;
/* 677 */             }
/* 678 */           }
/* 679 */           boolean agg_isNull26 = true;
/* 680 */           long agg_value29 = -1L;
/* 681 */
/* 682 */           boolean agg_isNull28 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 683 */           long agg_value31 = agg_isNull28 ? -1L : (agg_unsafeRowAggBuffer.getLong(1));
/* 684 */           boolean agg_isNull27 = agg_isNull28;
/* 685 */           long agg_value30 = agg_value31;
/* 686 */           if (agg_isNull27) {
/* 687 */             boolean agg_isNull29 = false;
/* 688 */             long agg_value32 = -1L;
/* 689 */             if (!false) {
/* 690 */               agg_value32 = (long) 0;
/* 691 */             }
/* 692 */             if (!agg_isNull29) {
/* 693 */               agg_isNull27 = false;
/* 694 */               agg_value30 = agg_value32;
/* 695 */             }
/* 696 */           }
/* 697 */
/* 698 */           if (!smj_isNull12) {
/* 699 */             agg_isNull26 = false; // resultCode could change nullability.
/* 700 */             agg_value29 = agg_value30 + smj_value16;
/* 701 */
/* 702 */           }
/* 703 */           boolean agg_isNull25 = agg_isNull26;
/* 704 */           long agg_value28 = agg_value29;
/* 705 */           if (agg_isNull25) {
/* 706 */             boolean agg_isNull32 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 707 */             long agg_value35 = agg_isNull32 ? -1L : (agg_unsafeRowAggBuffer.getLong(1));
/* 708 */             if (!agg_isNull32) {
/* 709 */               agg_isNull25 = false;
/* 710 */               agg_value28 = agg_value35;
/* 711 */             }
/* 712 */           }
/* 713 */           boolean agg_isNull34 = true;
/* 714 */           long agg_value37 = -1L;
/* 715 */
/* 716 */           boolean agg_isNull36 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 717 */           long agg_value39 = agg_isNull36 ? -1L : (agg_unsafeRowAggBuffer.getLong(2));
/* 718 */           boolean agg_isNull35 = agg_isNull36;
/* 719 */           long agg_value38 = agg_value39;
/* 720 */           if (agg_isNull35) {
/* 721 */             boolean agg_isNull37 = false;
/* 722 */             long agg_value40 = -1L;
/* 723 */             if (!false) {
/* 724 */               agg_value40 = (long) 0;
/* 725 */             }
/* 726 */             if (!agg_isNull37) {
/* 727 */               agg_isNull35 = false;
/* 728 */               agg_value38 = agg_value40;
/* 729 */             }
/* 730 */           }
/* 731 */
/* 732 */           boolean agg_isNull39 = smj_isNull16;
/* 733 */           long agg_value42 = -1L;
/* 734 */           if (!smj_isNull16) {
/* 735 */             agg_value42 = (long) smj_value20;
/* 736 */           }
/* 737 */           if (!agg_isNull39) {
/* 738 */             agg_isNull34 = false; // resultCode could change nullability.
/* 739 */             agg_value37 = agg_value38 + agg_value42;
/* 740 */
/* 741 */           }
/* 742 */           boolean agg_isNull33 = agg_isNull34;
/* 743 */           long agg_value36 = agg_value37;
/* 744 */           if (agg_isNull33) {
/* 745 */             boolean agg_isNull41 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 746 */             long agg_value44 = agg_isNull41 ? -1L : (agg_unsafeRowAggBuffer.getLong(2));
/* 747 */             if (!agg_isNull41) {
/* 748 */               agg_isNull33 = false;
/* 749 */               agg_value36 = agg_value44;
/* 750 */             }
/* 751 */           }
/* 752 */           // update unsafe row buffer
/* 753 */           if (!agg_isNull16) {
/* 754 */             agg_unsafeRowAggBuffer.setLong(0, agg_value19);
/* 755 */           } else {
/* 756 */             agg_unsafeRowAggBuffer.setNullAt(0);
/* 757 */           }
/* 758 */
/* 759 */           if (!agg_isNull25) {
/* 760 */             agg_unsafeRowAggBuffer.setLong(1, agg_value28);
/* 761 */           } else {
/* 762 */             agg_unsafeRowAggBuffer.setNullAt(1);
/* 763 */           }
/* 764 */
/* 765 */           if (!agg_isNull33) {
/* 766 */             agg_unsafeRowAggBuffer.setLong(2, agg_value36);
/* 767 */           } else {
/* 768 */             agg_unsafeRowAggBuffer.setNullAt(2);
/* 769 */           }
/* 770 */
/* 771 */         }
/* 772 */
/* 773 */       }
/* 774 */       if (shouldStop()) return;
/* 775 */     }
/* 776 */
/* 777 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 778 */
/* 779 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 780 */   }
/* 781 */
/* 782 */   private boolean findNextInnerJoinRows(
/* 783 */     scala.collection.Iterator leftIter,
/* 784 */     scala.collection.Iterator rightIter) {
/* 785 */     smj_leftRow = null;
/* 786 */     int comp = 0;
/* 787 */     while (smj_leftRow == null) {
/* 788 */       if (!leftIter.hasNext()) return false;
/* 789 */       smj_leftRow = (InternalRow) leftIter.next();
/* 790 */
/* 791 */       boolean smj_isNull = smj_leftRow.isNullAt(5);
/* 792 */       long smj_value = smj_isNull ? -1L : (smj_leftRow.getLong(5));
/* 793 */
/* 794 */       boolean smj_isNull1 = smj_leftRow.isNullAt(4);
/* 795 */       long smj_value1 = smj_isNull1 ? -1L : (smj_leftRow.getLong(4));
/* 796 */       if (smj_isNull || smj_isNull1) {
/* 797 */         smj_leftRow = null;
/* 798 */         continue;
/* 799 */       }
/* 800 */       if (!smj_matches.isEmpty()) {
/* 801 */         comp = 0;
/* 802 */         if (comp == 0) {
/* 803 */           comp = (smj_value > smj_value8 ? 1 : smj_value < smj_value8 ? -1 : 0);
/* 804 */         }
/* 805 */         if (comp == 0) {
/* 806 */           comp = (smj_value1 > smj_value9 ? 1 : smj_value1 < smj_value9 ? -1 : 0);
/* 807 */         }
/* 808 */
/* 809 */         if (comp == 0) {
/* 810 */           return true;
/* 811 */         }
/* 812 */         smj_matches.clear();
/* 813 */       }
/* 814 */
/* 815 */       do {
/* 816 */         if (smj_rightRow == null) {
/* 817 */           if (!rightIter.hasNext()) {
/* 818 */             smj_value8 = smj_value;
/* 819 */             smj_value9 = smj_value1;
/* 820 */             return !smj_matches.isEmpty();
/* 821 */           }
/* 822 */           smj_rightRow = (InternalRow) rightIter.next();
/* 823 */
/* 824 */           boolean smj_isNull3 = smj_rightRow.isNullAt(0);
/* 825 */           int smj_value3 = smj_isNull3 ? -1 : (smj_rightRow.getInt(0));
/* 826 */           boolean smj_isNull2 = smj_isNull3;
/* 827 */           long smj_value2 = -1L;
/* 828 */           if (!smj_isNull3) {
/* 829 */             smj_value2 = (long) smj_value3;
/* 830 */           }
/* 831 */
/* 832 */           boolean smj_isNull5 = smj_rightRow.isNullAt(1);
/* 833 */           int smj_value5 = smj_isNull5 ? -1 : (smj_rightRow.getInt(1));
/* 834 */           boolean smj_isNull4 = smj_isNull5;
/* 835 */           long smj_value4 = -1L;
/* 836 */           if (!smj_isNull5) {
/* 837 */             smj_value4 = (long) smj_value5;
/* 838 */           }
/* 839 */           if (smj_isNull2 || smj_isNull4) {
/* 840 */             smj_rightRow = null;
/* 841 */             continue;
/* 842 */           }
/* 843 */           smj_value6 = smj_value2;
/* 844 */           smj_value7 = smj_value4;
/* 845 */         }
/* 846 */
/* 847 */         comp = 0;
/* 848 */         if (comp == 0) {
/* 849 */           comp = (smj_value > smj_value6 ? 1 : smj_value < smj_value6 ? -1 : 0);
/* 850 */         }
/* 851 */         if (comp == 0) {
/* 852 */           comp = (smj_value1 > smj_value7 ? 1 : smj_value1 < smj_value7 ? -1 : 0);
/* 853 */         }
/* 854 */
/* 855 */         if (comp > 0) {
/* 856 */           smj_rightRow = null;
/* 857 */         } else if (comp < 0) {
/* 858 */           if (!smj_matches.isEmpty()) {
/* 859 */             smj_value8 = smj_value;
/* 860 */             smj_value9 = smj_value1;
/* 861 */             return true;
/* 862 */           }
/* 863 */           smj_leftRow = null;
/* 864 */         } else {
/* 865 */           smj_matches.add((UnsafeRow) smj_rightRow);
/* 866 */           smj_rightRow = null;;
/* 867 */         }
/* 868 */       } while (smj_leftRow != null);
/* 869 */     }
/* 870 */     return false; // unreachable
/* 871 */   }
/* 872 */
/* 873 */   private void wholestagecodegen_init_5() {
/* 874 */     this.project_rowWriter5 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder5, 7);
/* 875 */     agg_result4 = new UnsafeRow(4);
/* 876 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result4, 128);
/* 877 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 4);
/* 878 */
/* 879 */     agg_unsafeRowJoiner = agg_plan.createUnsafeJoiner();
/* 880 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[21];
/* 881 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[22];
/* 882 */
/* 883 */   }
/* 884 */
/* 885 */   private void wholestagecodegen_init_2() {
/* 886 */     bhj_relation1 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast1.value()).asReadOnlyCopy();
/* 887 */     incPeakExecutionMemory(bhj_relation1.estimatedSize());
/* 888 */
/* 889 */     this.bhj_numOutputRows1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[14];
/* 890 */     bhj_result1 = new UnsafeRow(8);
/* 891 */     this.bhj_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result1, 0);
/* 892 */     this.bhj_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder1, 8);
/* 893 */     project_result2 = new UnsafeRow(6);
/* 894 */     this.project_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result2, 0);
/* 895 */     this.project_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder2, 6);
/* 896 */     this.bhj_broadcast2 = (org.apache.spark.broadcast.TorrentBroadcast) references[15];
/* 897 */
/* 898 */     bhj_relation2 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast2.value()).asReadOnlyCopy();
/* 899 */     incPeakExecutionMemory(bhj_relation2.estimatedSize());
/* 900 */
/* 901 */   }
/* 902 */
/* 903 */   private void wholestagecodegen_init_1() {
/* 904 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 8);
/* 905 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[11];
/* 906 */
/* 907 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 908 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 909 */
/* 910 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[12];
/* 911 */     bhj_result = new UnsafeRow(9);
/* 912 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 0);
/* 913 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 9);
/* 914 */     project_result1 = new UnsafeRow(7);
/* 915 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 0);
/* 916 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 7);
/* 917 */     this.bhj_broadcast1 = (org.apache.spark.broadcast.TorrentBroadcast) references[13];
/* 918 */
/* 919 */   }
/* 920 */
/* 921 */   private void wholestagecodegen_init_4() {
/* 922 */     this.bhj_rowWriter3 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder3, 8);
/* 923 */     project_result4 = new UnsafeRow(6);
/* 924 */     this.project_holder4 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result4, 64);
/* 925 */     this.project_rowWriter4 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder4, 6);
/* 926 */     this.bhj_broadcast4 = (org.apache.spark.broadcast.TorrentBroadcast) references[19];
/* 927 */
/* 928 */     bhj_relation4 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast4.value()).asReadOnlyCopy();
/* 929 */     incPeakExecutionMemory(bhj_relation4.estimatedSize());
/* 930 */
/* 931 */     this.bhj_numOutputRows4 = (org.apache.spark.sql.execution.metric.SQLMetric) references[20];
/* 932 */     bhj_result4 = new UnsafeRow(9);
/* 933 */     this.bhj_holder4 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result4, 128);
/* 934 */     this.bhj_rowWriter4 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder4, 9);
/* 935 */     project_result5 = new UnsafeRow(7);
/* 936 */     this.project_holder5 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result5, 128);
/* 937 */
/* 938 */   }
/* 939 */
/* 940 */   protected void processNext() throws java.io.IOException {
/* 941 */     if (!agg_initAgg) {
/* 942 */       agg_initAgg = true;
/* 943 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 944 */       agg_doAggregateWithKeys();
/* 945 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 946 */     }
/* 947 */
/* 948 */     // output the result
/* 949 */
/* 950 */     while (agg_fastHashMapIter.next()) {
/* 951 */       wholestagecodegen_numOutputRows.add(1);
/* 952 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 953 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 954 */
/* 955 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 956 */
/* 957 */       append(agg_resultRow.copy());
/* 958 */
/* 959 */       if (shouldStop()) return;
/* 960 */     }
/* 961 */     agg_fastHashMap.close();
/* 962 */
/* 963 */     while (agg_mapIter.next()) {
/* 964 */       wholestagecodegen_numOutputRows.add(1);
/* 965 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 966 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 967 */
/* 968 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 969 */
/* 970 */       append(agg_resultRow.copy());
/* 971 */
/* 972 */       if (shouldStop()) return;
/* 973 */     }
/* 974 */
/* 975 */     agg_mapIter.close();
/* 976 */     if (agg_sorter == null) {
/* 977 */       agg_hashMap.free();
/* 978 */     }
/* 979 */   }
/* 980 */ }
