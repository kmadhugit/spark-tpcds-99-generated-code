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
/* 023 */   private scala.collection.Iterator inputadapter_input;
/* 024 */   private UnsafeRow project_result;
/* 025 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 026 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 027 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast;
/* 028 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation;
/* 029 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows;
/* 030 */   private UnsafeRow bhj_result;
/* 031 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder;
/* 032 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter;
/* 033 */   private UnsafeRow project_result1;
/* 034 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder1;
/* 035 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter1;
/* 036 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast1;
/* 037 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation1;
/* 038 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows1;
/* 039 */   private UnsafeRow bhj_result1;
/* 040 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder1;
/* 041 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter1;
/* 042 */   private UnsafeRow project_result2;
/* 043 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder2;
/* 044 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter2;
/* 045 */   private UnsafeRow agg_result5;
/* 046 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 047 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 048 */   private int agg_value16;
/* 049 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowJoiner agg_unsafeRowJoiner;
/* 050 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 051 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 052 */
/* 053 */   public GeneratedIterator(Object[] references) {
/* 054 */     this.references = references;
/* 055 */   }
/* 056 */
/* 057 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 058 */     partitionIndex = index;
/* 059 */     this.inputs = inputs;
/* 060 */     wholestagecodegen_init_0();
/* 061 */     wholestagecodegen_init_1();
/* 062 */     wholestagecodegen_init_2();
/* 063 */
/* 064 */   }
/* 065 */
/* 066 */   private void wholestagecodegen_init_0() {
/* 067 */     agg_initAgg = false;
/* 068 */
/* 069 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 070 */     agg_fastHashMap = new agg_FastHashMap(agg_plan.getTaskMemoryManager(), agg_plan.getEmptyAggregationBuffer());
/* 071 */
/* 072 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 073 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 074 */     inputadapter_input = inputs[0];
/* 075 */     project_result = new UnsafeRow(2);
/* 076 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 077 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 2);
/* 078 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[11];
/* 079 */
/* 080 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 081 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 082 */
/* 083 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[12];
/* 084 */
/* 085 */   }
/* 086 */
/* 087 */   public class agg_FastHashMap {
/* 088 */     private org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch batch;
/* 089 */     private int[] buckets;
/* 090 */     private int capacity = 1 << 16;
/* 091 */     private double loadFactor = 0.5;
/* 092 */     private int numBuckets = (int) (capacity / loadFactor);
/* 093 */     private int maxSteps = 2;
/* 094 */     private int numRows = 0;
/* 095 */     private org.apache.spark.sql.types.StructType keySchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[3])", org.apache.spark.sql.types.DataTypes.StringType)
/* 096 */     .add("((java.lang.String) references[4])", org.apache.spark.sql.types.DataTypes.StringType)
/* 097 */     .add("((java.lang.String) references[5])", org.apache.spark.sql.types.DataTypes.StringType)
/* 098 */     .add("((java.lang.String) references[6])", org.apache.spark.sql.types.DataTypes.IntegerType)
/* 099 */     .add("((java.lang.String) references[7])", org.apache.spark.sql.types.DataTypes.StringType);
/* 100 */     private org.apache.spark.sql.types.StructType valueSchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[8])", org.apache.spark.sql.types.DataTypes.LongType)
/* 101 */     .add("((java.lang.String) references[9])", org.apache.spark.sql.types.DataTypes.LongType)
/* 102 */     .add("((java.lang.String) references[10])", org.apache.spark.sql.types.DataTypes.LongType);
/* 103 */     private Object emptyVBase;
/* 104 */     private long emptyVOff;
/* 105 */     private int emptyVLen;
/* 106 */     private boolean isBatchFull = false;
/* 107 */
/* 108 */     public agg_FastHashMap(
/* 109 */       org.apache.spark.memory.TaskMemoryManager taskMemoryManager,
/* 110 */       InternalRow emptyAggregationBuffer) {
/* 111 */       batch = org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch
/* 112 */       .allocate(keySchema, valueSchema, taskMemoryManager, capacity);
/* 113 */
/* 114 */       final UnsafeProjection valueProjection = UnsafeProjection.create(valueSchema);
/* 115 */       final byte[] emptyBuffer = valueProjection.apply(emptyAggregationBuffer).getBytes();
/* 116 */
/* 117 */       emptyVBase = emptyBuffer;
/* 118 */       emptyVOff = Platform.BYTE_ARRAY_OFFSET;
/* 119 */       emptyVLen = emptyBuffer.length;
/* 120 */
/* 121 */       buckets = new int[numBuckets];
/* 122 */       java.util.Arrays.fill(buckets, -1);
/* 123 */     }
/* 124 */
/* 125 */     public org.apache.spark.sql.catalyst.expressions.UnsafeRow findOrInsert(UTF8String agg_key, UTF8String agg_key1, UTF8String agg_key2, int agg_key3, UTF8String agg_key4) {
/* 126 */       long h = hash(agg_key, agg_key1, agg_key2, agg_key3, agg_key4);
/* 127 */       int step = 0;
/* 128 */       int idx = (int) h & (numBuckets - 1);
/* 129 */       while (step < maxSteps) {
/* 130 */         // Return bucket index if it's either an empty slot or already contains the key
/* 131 */         if (buckets[idx] == -1) {
/* 132 */           if (numRows < capacity && !isBatchFull) {
/* 133 */             // creating the unsafe for new entry
/* 134 */             UnsafeRow agg_result = new UnsafeRow(5);
/* 135 */             org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder
/* 136 */             = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result,
/* 137 */               128);
/* 138 */             org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter
/* 139 */             = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(
/* 140 */               agg_holder,
/* 141 */               5);
/* 142 */             agg_holder.reset(); //TODO: investigate if reset or zeroout are actually needed
/* 143 */             agg_rowWriter.zeroOutNullBytes();
/* 144 */             agg_rowWriter.write(0, agg_key);
/* 145 */             agg_rowWriter.write(1, agg_key1);
/* 146 */             agg_rowWriter.write(2, agg_key2);
/* 147 */             agg_rowWriter.write(3, agg_key3);
/* 148 */             agg_rowWriter.write(4, agg_key4);
/* 149 */             agg_result.setTotalSize(agg_holder.totalSize());
/* 150 */             Object kbase = agg_result.getBaseObject();
/* 151 */             long koff = agg_result.getBaseOffset();
/* 152 */             int klen = agg_result.getSizeInBytes();
/* 153 */
/* 154 */             UnsafeRow vRow
/* 155 */             = batch.appendRow(kbase, koff, klen, emptyVBase, emptyVOff, emptyVLen);
/* 156 */             if (vRow == null) {
/* 157 */               isBatchFull = true;
/* 158 */             } else {
/* 159 */               buckets[idx] = numRows++;
/* 160 */             }
/* 161 */             return vRow;
/* 162 */           } else {
/* 163 */             // No more space
/* 164 */             return null;
/* 165 */           }
/* 166 */         } else if (equals(idx, agg_key, agg_key1, agg_key2, agg_key3, agg_key4)) {
/* 167 */           return batch.getValueRow(buckets[idx]);
/* 168 */         }
/* 169 */         idx = (idx + 1) & (numBuckets - 1);
/* 170 */         step++;
/* 171 */       }
/* 172 */       // Didn't find it
/* 173 */       return null;
/* 174 */     }
/* 175 */
/* 176 */     private boolean equals(int idx, UTF8String agg_key, UTF8String agg_key1, UTF8String agg_key2, int agg_key3, UTF8String agg_key4) {
/* 177 */       UnsafeRow row = batch.getKeyRow(buckets[idx]);
/* 178 */       return (row.getUTF8String(0).equals(agg_key)) && (row.getUTF8String(1).equals(agg_key1)) && (row.getUTF8String(2).equals(agg_key2)) && (row.getInt(3) == agg_key3) && (row.getUTF8String(4).equals(agg_key4));
/* 179 */     }
/* 180 */
/* 181 */     private long hash(UTF8String agg_key, UTF8String agg_key1, UTF8String agg_key2, int agg_key3, UTF8String agg_key4) {
/* 182 */       long agg_hash = 0;
/* 183 */
/* 184 */       int agg_result = 0;
/* 185 */       byte[] agg_bytes = agg_key.getBytes();
/* 186 */       for (int i = 0; i < agg_bytes.length; i++) {
/* 187 */         int agg_hash1 = agg_bytes[i];
/* 188 */         agg_result = (agg_result ^ (0x9e3779b9)) + agg_hash1 + (agg_result << 6) + (agg_result >>> 2);
/* 189 */       }
/* 190 */
/* 191 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result + (agg_hash << 6) + (agg_hash >>> 2);
/* 192 */
/* 193 */       int agg_result1 = 0;
/* 194 */       byte[] agg_bytes1 = agg_key1.getBytes();
/* 195 */       for (int i = 0; i < agg_bytes1.length; i++) {
/* 196 */         int agg_hash2 = agg_bytes1[i];
/* 197 */         agg_result1 = (agg_result1 ^ (0x9e3779b9)) + agg_hash2 + (agg_result1 << 6) + (agg_result1 >>> 2);
/* 198 */       }
/* 199 */
/* 200 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result1 + (agg_hash << 6) + (agg_hash >>> 2);
/* 201 */
/* 202 */       int agg_result2 = 0;
/* 203 */       byte[] agg_bytes2 = agg_key2.getBytes();
/* 204 */       for (int i = 0; i < agg_bytes2.length; i++) {
/* 205 */         int agg_hash3 = agg_bytes2[i];
/* 206 */         agg_result2 = (agg_result2 ^ (0x9e3779b9)) + agg_hash3 + (agg_result2 << 6) + (agg_result2 >>> 2);
/* 207 */       }
/* 208 */
/* 209 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result2 + (agg_hash << 6) + (agg_hash >>> 2);
/* 210 */
/* 211 */       int agg_result3 = agg_key3;
/* 212 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result3 + (agg_hash << 6) + (agg_hash >>> 2);
/* 213 */
/* 214 */       int agg_result4 = 0;
/* 215 */       byte[] agg_bytes3 = agg_key4.getBytes();
/* 216 */       for (int i = 0; i < agg_bytes3.length; i++) {
/* 217 */         int agg_hash4 = agg_bytes3[i];
/* 218 */         agg_result4 = (agg_result4 ^ (0x9e3779b9)) + agg_hash4 + (agg_result4 << 6) + (agg_result4 >>> 2);
/* 219 */       }
/* 220 */
/* 221 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result4 + (agg_hash << 6) + (agg_hash >>> 2);
/* 222 */
/* 223 */       return agg_hash;
/* 224 */     }
/* 225 */
/* 226 */     public org.apache.spark.unsafe.KVIterator<UnsafeRow, UnsafeRow> rowIterator() {
/* 227 */       return batch.rowIterator();
/* 228 */     }
/* 229 */
/* 230 */     public void close() {
/* 231 */       batch.close();
/* 232 */     }
/* 233 */
/* 234 */   }
/* 235 */
/* 236 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 237 */     agg_hashMap = agg_plan.createHashMap();
/* 238 */
/* 239 */     while (inputadapter_input.hasNext() && !stopEarly()) {
/* 240 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 241 */       boolean inputadapter_isNull4 = inputadapter_row.isNullAt(4);
/* 242 */       int inputadapter_value4 = inputadapter_isNull4 ? -1 : (inputadapter_row.getInt(4));
/* 243 */
/* 244 */       // generate join key for stream side
/* 245 */
/* 246 */       boolean bhj_isNull = inputadapter_isNull4;
/* 247 */       long bhj_value = -1L;
/* 248 */       if (!inputadapter_isNull4) {
/* 249 */         bhj_value = (long) inputadapter_value4;
/* 250 */       }
/* 251 */       // find matches from HashedRelation
/* 252 */       UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 253 */       if (bhj_matched == null) continue;
/* 254 */
/* 255 */       bhj_numOutputRows.add(1);
/* 256 */
/* 257 */       boolean inputadapter_isNull2 = inputadapter_row.isNullAt(2);
/* 258 */       int inputadapter_value2 = inputadapter_isNull2 ? -1 : (inputadapter_row.getInt(2));
/* 259 */
/* 260 */       // generate join key for stream side
/* 261 */
/* 262 */       boolean bhj_isNull6 = inputadapter_isNull2;
/* 263 */       long bhj_value6 = -1L;
/* 264 */       if (!inputadapter_isNull2) {
/* 265 */         bhj_value6 = (long) inputadapter_value2;
/* 266 */       }
/* 267 */       // find matches from HashedRelation
/* 268 */       UnsafeRow bhj_matched1 = bhj_isNull6 ? null: (UnsafeRow)bhj_relation1.getValue(bhj_value6);
/* 269 */       if (bhj_matched1 == null) continue;
/* 270 */
/* 271 */       bhj_numOutputRows1.add(1);
/* 272 */
/* 273 */       boolean bhj_isNull9 = bhj_matched1.isNullAt(1);
/* 274 */       UTF8String bhj_value9 = bhj_isNull9 ? null : (bhj_matched1.getUTF8String(1));
/* 275 */       boolean bhj_isNull10 = bhj_matched1.isNullAt(2);
/* 276 */       UTF8String bhj_value10 = bhj_isNull10 ? null : (bhj_matched1.getUTF8String(2));
/* 277 */       boolean bhj_isNull11 = bhj_matched1.isNullAt(3);
/* 278 */       UTF8String bhj_value11 = bhj_isNull11 ? null : (bhj_matched1.getUTF8String(3));
/* 279 */       boolean bhj_isNull12 = bhj_matched1.isNullAt(4);
/* 280 */       int bhj_value12 = bhj_isNull12 ? -1 : (bhj_matched1.getInt(4));
/* 281 */       boolean bhj_isNull13 = bhj_matched1.isNullAt(5);
/* 282 */       UTF8String bhj_value13 = bhj_isNull13 ? null : (bhj_matched1.getUTF8String(5));
/* 283 */
/* 284 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 285 */
/* 286 */       UnsafeRow agg_fastAggBuffer = null;
/* 287 */
/* 288 */       if (true) {
/* 289 */         if (!bhj_isNull9 && !bhj_isNull10 && !bhj_isNull11 && !bhj_isNull12 && !bhj_isNull13) {
/* 290 */           agg_fastAggBuffer = agg_fastHashMap.findOrInsert(
/* 291 */             bhj_value9, bhj_value10, bhj_value11, bhj_value12, bhj_value13);
/* 292 */         }
/* 293 */       }
/* 294 */
/* 295 */       if (agg_fastAggBuffer == null) {
/* 296 */         // generate grouping key
/* 297 */         agg_holder.reset();
/* 298 */
/* 299 */         agg_rowWriter.zeroOutNullBytes();
/* 300 */
/* 301 */         if (bhj_isNull9) {
/* 302 */           agg_rowWriter.setNullAt(0);
/* 303 */         } else {
/* 304 */           agg_rowWriter.write(0, bhj_value9);
/* 305 */         }
/* 306 */
/* 307 */         if (bhj_isNull10) {
/* 308 */           agg_rowWriter.setNullAt(1);
/* 309 */         } else {
/* 310 */           agg_rowWriter.write(1, bhj_value10);
/* 311 */         }
/* 312 */
/* 313 */         if (bhj_isNull11) {
/* 314 */           agg_rowWriter.setNullAt(2);
/* 315 */         } else {
/* 316 */           agg_rowWriter.write(2, bhj_value11);
/* 317 */         }
/* 318 */
/* 319 */         if (bhj_isNull12) {
/* 320 */           agg_rowWriter.setNullAt(3);
/* 321 */         } else {
/* 322 */           agg_rowWriter.write(3, bhj_value12);
/* 323 */         }
/* 324 */
/* 325 */         if (bhj_isNull13) {
/* 326 */           agg_rowWriter.setNullAt(4);
/* 327 */         } else {
/* 328 */           agg_rowWriter.write(4, bhj_value13);
/* 329 */         }
/* 330 */         agg_result5.setTotalSize(agg_holder.totalSize());
/* 331 */         agg_value16 = 42;
/* 332 */
/* 333 */         if (!bhj_isNull9) {
/* 334 */           agg_value16 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value9.getBaseObject(), bhj_value9.getBaseOffset(), bhj_value9.numBytes(), agg_value16);
/* 335 */         }
/* 336 */
/* 337 */         if (!bhj_isNull10) {
/* 338 */           agg_value16 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value10.getBaseObject(), bhj_value10.getBaseOffset(), bhj_value10.numBytes(), agg_value16);
/* 339 */         }
/* 340 */
/* 341 */         if (!bhj_isNull11) {
/* 342 */           agg_value16 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value11.getBaseObject(), bhj_value11.getBaseOffset(), bhj_value11.numBytes(), agg_value16);
/* 343 */         }
/* 344 */
/* 345 */         if (!bhj_isNull12) {
/* 346 */           agg_value16 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(bhj_value12, agg_value16);
/* 347 */         }
/* 348 */
/* 349 */         if (!bhj_isNull13) {
/* 350 */           agg_value16 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value13.getBaseObject(), bhj_value13.getBaseOffset(), bhj_value13.numBytes(), agg_value16);
/* 351 */         }
/* 352 */         if (true) {
/* 353 */           // try to get the buffer from hash map
/* 354 */           agg_unsafeRowAggBuffer =
/* 355 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result5, agg_value16);
/* 356 */         }
/* 357 */         if (agg_unsafeRowAggBuffer == null) {
/* 358 */           if (agg_sorter == null) {
/* 359 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 360 */           } else {
/* 361 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 362 */           }
/* 363 */
/* 364 */           // the hash map had be spilled, it should have enough memory now,
/* 365 */           // try  to allocate buffer again.
/* 366 */           agg_unsafeRowAggBuffer =
/* 367 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result5, agg_value16);
/* 368 */           if (agg_unsafeRowAggBuffer == null) {
/* 369 */             // failed to allocate the first page
/* 370 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 371 */           }
/* 372 */         }
/* 373 */       }
/* 374 */
/* 375 */       if (agg_fastAggBuffer != null) {
/* 376 */         // update fast row
/* 377 */
/* 378 */         // common sub-expressions
/* 379 */
/* 380 */         // evaluate aggregate function
/* 381 */         boolean agg_isNull28 = false;
/* 382 */
/* 383 */         long agg_value32 = agg_fastAggBuffer.getLong(0);
/* 384 */
/* 385 */         long agg_value31 = -1L;
/* 386 */         agg_value31 = agg_value32 + 1L;
/* 387 */         boolean agg_isNull31 = false;
/* 388 */
/* 389 */         long agg_value35 = agg_fastAggBuffer.getLong(1);
/* 390 */
/* 391 */         long agg_value34 = -1L;
/* 392 */         agg_value34 = agg_value35 + 1L;
/* 393 */         boolean agg_isNull34 = false;
/* 394 */
/* 395 */         long agg_value38 = agg_fastAggBuffer.getLong(2);
/* 396 */
/* 397 */         long agg_value37 = -1L;
/* 398 */         agg_value37 = agg_value38 + 1L;
/* 399 */         // update fast row
/* 400 */         agg_fastAggBuffer.setLong(0, agg_value31);
/* 401 */         agg_fastAggBuffer.setLong(1, agg_value34);
/* 402 */         agg_fastAggBuffer.setLong(2, agg_value37);
/* 403 */
/* 404 */       } else {
/* 405 */         // update unsafe row
/* 406 */
/* 407 */         // common sub-expressions
/* 408 */
/* 409 */         // evaluate aggregate function
/* 410 */         boolean agg_isNull19 = false;
/* 411 */
/* 412 */         long agg_value23 = agg_unsafeRowAggBuffer.getLong(0);
/* 413 */
/* 414 */         long agg_value22 = -1L;
/* 415 */         agg_value22 = agg_value23 + 1L;
/* 416 */         boolean agg_isNull22 = false;
/* 417 */
/* 418 */         long agg_value26 = agg_unsafeRowAggBuffer.getLong(1);
/* 419 */
/* 420 */         long agg_value25 = -1L;
/* 421 */         agg_value25 = agg_value26 + 1L;
/* 422 */         boolean agg_isNull25 = false;
/* 423 */
/* 424 */         long agg_value29 = agg_unsafeRowAggBuffer.getLong(2);
/* 425 */
/* 426 */         long agg_value28 = -1L;
/* 427 */         agg_value28 = agg_value29 + 1L;
/* 428 */         // update unsafe row buffer
/* 429 */         agg_unsafeRowAggBuffer.setLong(0, agg_value22);
/* 430 */         agg_unsafeRowAggBuffer.setLong(1, agg_value25);
/* 431 */         agg_unsafeRowAggBuffer.setLong(2, agg_value28);
/* 432 */
/* 433 */       }
/* 434 */       if (shouldStop()) return;
/* 435 */     }
/* 436 */
/* 437 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 438 */
/* 439 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 440 */   }
/* 441 */
/* 442 */   private void wholestagecodegen_init_2() {
/* 443 */     project_result2 = new UnsafeRow(5);
/* 444 */     this.project_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result2, 128);
/* 445 */     this.project_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder2, 5);
/* 446 */     agg_result5 = new UnsafeRow(5);
/* 447 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result5, 128);
/* 448 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 5);
/* 449 */
/* 450 */     agg_unsafeRowJoiner = agg_plan.createUnsafeJoiner();
/* 451 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[15];
/* 452 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[16];
/* 453 */
/* 454 */   }
/* 455 */
/* 456 */   private void wholestagecodegen_init_1() {
/* 457 */     bhj_result = new UnsafeRow(3);
/* 458 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 0);
/* 459 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 3);
/* 460 */     project_result1 = new UnsafeRow(1);
/* 461 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 0);
/* 462 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 1);
/* 463 */     this.bhj_broadcast1 = (org.apache.spark.broadcast.TorrentBroadcast) references[13];
/* 464 */
/* 465 */     bhj_relation1 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast1.value()).asReadOnlyCopy();
/* 466 */     incPeakExecutionMemory(bhj_relation1.estimatedSize());
/* 467 */
/* 468 */     this.bhj_numOutputRows1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[14];
/* 469 */     bhj_result1 = new UnsafeRow(7);
/* 470 */     this.bhj_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result1, 128);
/* 471 */     this.bhj_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder1, 7);
/* 472 */
/* 473 */   }
/* 474 */
/* 475 */   protected void processNext() throws java.io.IOException {
/* 476 */     if (!agg_initAgg) {
/* 477 */       agg_initAgg = true;
/* 478 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 479 */       agg_doAggregateWithKeys();
/* 480 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 481 */     }
/* 482 */
/* 483 */     // output the result
/* 484 */
/* 485 */     while (agg_fastHashMapIter.next()) {
/* 486 */       wholestagecodegen_numOutputRows.add(1);
/* 487 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 488 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 489 */
/* 490 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 491 */
/* 492 */       append(agg_resultRow);
/* 493 */
/* 494 */       if (shouldStop()) return;
/* 495 */     }
/* 496 */     agg_fastHashMap.close();
/* 497 */
/* 498 */     while (agg_mapIter.next()) {
/* 499 */       wholestagecodegen_numOutputRows.add(1);
/* 500 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 501 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 502 */
/* 503 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 504 */
/* 505 */       append(agg_resultRow);
/* 506 */
/* 507 */       if (shouldStop()) return;
/* 508 */     }
/* 509 */
/* 510 */     agg_mapIter.close();
/* 511 */     if (agg_sorter == null) {
/* 512 */       agg_hashMap.free();
/* 513 */     }
/* 514 */   }
/* 515 */ }
