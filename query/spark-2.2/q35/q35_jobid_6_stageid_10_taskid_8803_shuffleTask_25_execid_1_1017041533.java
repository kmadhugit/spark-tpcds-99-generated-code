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
/* 012 */   private int agg_bufValue1;
/* 013 */   private boolean agg_bufIsNull2;
/* 014 */   private int agg_bufValue2;
/* 015 */   private boolean agg_bufIsNull3;
/* 016 */   private double agg_bufValue3;
/* 017 */   private boolean agg_bufIsNull4;
/* 018 */   private long agg_bufValue4;
/* 019 */   private boolean agg_bufIsNull5;
/* 020 */   private long agg_bufValue5;
/* 021 */   private boolean agg_bufIsNull6;
/* 022 */   private int agg_bufValue6;
/* 023 */   private boolean agg_bufIsNull7;
/* 024 */   private int agg_bufValue7;
/* 025 */   private boolean agg_bufIsNull8;
/* 026 */   private double agg_bufValue8;
/* 027 */   private boolean agg_bufIsNull9;
/* 028 */   private long agg_bufValue9;
/* 029 */   private boolean agg_bufIsNull10;
/* 030 */   private long agg_bufValue10;
/* 031 */   private boolean agg_bufIsNull11;
/* 032 */   private int agg_bufValue11;
/* 033 */   private boolean agg_bufIsNull12;
/* 034 */   private int agg_bufValue12;
/* 035 */   private boolean agg_bufIsNull13;
/* 036 */   private double agg_bufValue13;
/* 037 */   private boolean agg_bufIsNull14;
/* 038 */   private long agg_bufValue14;
/* 039 */   private org.apache.spark.sql.execution.aggregate.HashAggregateExec agg_plan;
/* 040 */   private agg_FastHashMap agg_fastHashMap;
/* 041 */   private org.apache.spark.unsafe.KVIterator agg_fastHashMapIter;
/* 042 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap;
/* 043 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter;
/* 044 */   private org.apache.spark.unsafe.KVIterator agg_mapIter;
/* 045 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory;
/* 046 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize;
/* 047 */   private scala.collection.Iterator inputadapter_input;
/* 048 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 049 */   private UnsafeRow filter_result;
/* 050 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 051 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
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
/* 073 */   private UnsafeRow agg_result6;
/* 074 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 075 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 076 */   private int agg_value45;
/* 077 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowJoiner agg_unsafeRowJoiner;
/* 078 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 079 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 080 */
/* 081 */   public GeneratedIterator(Object[] references) {
/* 082 */     this.references = references;
/* 083 */   }
/* 084 */
/* 085 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 086 */     partitionIndex = index;
/* 087 */     this.inputs = inputs;
/* 088 */     wholestagecodegen_init_0();
/* 089 */     wholestagecodegen_init_1();
/* 090 */     wholestagecodegen_init_2();
/* 091 */
/* 092 */   }
/* 093 */
/* 094 */   private void wholestagecodegen_init_0() {
/* 095 */     agg_initAgg = false;
/* 096 */
/* 097 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 098 */     agg_fastHashMap = new agg_FastHashMap(agg_plan.getTaskMemoryManager(), agg_plan.getEmptyAggregationBuffer());
/* 099 */
/* 100 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 101 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 102 */     inputadapter_input = inputs[0];
/* 103 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[24];
/* 104 */     filter_result = new UnsafeRow(20);
/* 105 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 288);
/* 106 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 20);
/* 107 */     project_result = new UnsafeRow(2);
/* 108 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 109 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 2);
/* 110 */
/* 111 */   }
/* 112 */
/* 113 */   public class agg_FastHashMap {
/* 114 */     private org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch batch;
/* 115 */     private int[] buckets;
/* 116 */     private int capacity = 1 << 16;
/* 117 */     private double loadFactor = 0.5;
/* 118 */     private int numBuckets = (int) (capacity / loadFactor);
/* 119 */     private int maxSteps = 2;
/* 120 */     private int numRows = 0;
/* 121 */     private org.apache.spark.sql.types.StructType keySchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[3])", org.apache.spark.sql.types.DataTypes.StringType)
/* 122 */     .add("((java.lang.String) references[4])", org.apache.spark.sql.types.DataTypes.StringType)
/* 123 */     .add("((java.lang.String) references[5])", org.apache.spark.sql.types.DataTypes.StringType)
/* 124 */     .add("((java.lang.String) references[6])", org.apache.spark.sql.types.DataTypes.IntegerType)
/* 125 */     .add("((java.lang.String) references[7])", org.apache.spark.sql.types.DataTypes.IntegerType)
/* 126 */     .add("((java.lang.String) references[8])", org.apache.spark.sql.types.DataTypes.IntegerType);
/* 127 */     private org.apache.spark.sql.types.StructType valueSchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[9])", org.apache.spark.sql.types.DataTypes.LongType)
/* 128 */     .add("((java.lang.String) references[10])", org.apache.spark.sql.types.DataTypes.IntegerType)
/* 129 */     .add("((java.lang.String) references[11])", org.apache.spark.sql.types.DataTypes.IntegerType)
/* 130 */     .add("((java.lang.String) references[12])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 131 */     .add("((java.lang.String) references[13])", org.apache.spark.sql.types.DataTypes.LongType)
/* 132 */     .add("((java.lang.String) references[14])", org.apache.spark.sql.types.DataTypes.LongType)
/* 133 */     .add("((java.lang.String) references[15])", org.apache.spark.sql.types.DataTypes.IntegerType)
/* 134 */     .add("((java.lang.String) references[16])", org.apache.spark.sql.types.DataTypes.IntegerType)
/* 135 */     .add("((java.lang.String) references[17])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 136 */     .add("((java.lang.String) references[18])", org.apache.spark.sql.types.DataTypes.LongType)
/* 137 */     .add("((java.lang.String) references[19])", org.apache.spark.sql.types.DataTypes.LongType)
/* 138 */     .add("((java.lang.String) references[20])", org.apache.spark.sql.types.DataTypes.IntegerType)
/* 139 */     .add("((java.lang.String) references[21])", org.apache.spark.sql.types.DataTypes.IntegerType)
/* 140 */     .add("((java.lang.String) references[22])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 141 */     .add("((java.lang.String) references[23])", org.apache.spark.sql.types.DataTypes.LongType);
/* 142 */     private Object emptyVBase;
/* 143 */     private long emptyVOff;
/* 144 */     private int emptyVLen;
/* 145 */     private boolean isBatchFull = false;
/* 146 */
/* 147 */     public agg_FastHashMap(
/* 148 */       org.apache.spark.memory.TaskMemoryManager taskMemoryManager,
/* 149 */       InternalRow emptyAggregationBuffer) {
/* 150 */       batch = org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch
/* 151 */       .allocate(keySchema, valueSchema, taskMemoryManager, capacity);
/* 152 */
/* 153 */       final UnsafeProjection valueProjection = UnsafeProjection.create(valueSchema);
/* 154 */       final byte[] emptyBuffer = valueProjection.apply(emptyAggregationBuffer).getBytes();
/* 155 */
/* 156 */       emptyVBase = emptyBuffer;
/* 157 */       emptyVOff = Platform.BYTE_ARRAY_OFFSET;
/* 158 */       emptyVLen = emptyBuffer.length;
/* 159 */
/* 160 */       buckets = new int[numBuckets];
/* 161 */       java.util.Arrays.fill(buckets, -1);
/* 162 */     }
/* 163 */
/* 164 */     public org.apache.spark.sql.catalyst.expressions.UnsafeRow findOrInsert(UTF8String agg_key, UTF8String agg_key1, UTF8String agg_key2, int agg_key3, int agg_key4, int agg_key5) {
/* 165 */       long h = hash(agg_key, agg_key1, agg_key2, agg_key3, agg_key4, agg_key5);
/* 166 */       int step = 0;
/* 167 */       int idx = (int) h & (numBuckets - 1);
/* 168 */       while (step < maxSteps) {
/* 169 */         // Return bucket index if it's either an empty slot or already contains the key
/* 170 */         if (buckets[idx] == -1) {
/* 171 */           if (numRows < capacity && !isBatchFull) {
/* 172 */             // creating the unsafe for new entry
/* 173 */             UnsafeRow agg_result = new UnsafeRow(6);
/* 174 */             org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder
/* 175 */             = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result,
/* 176 */               96);
/* 177 */             org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter
/* 178 */             = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(
/* 179 */               agg_holder,
/* 180 */               6);
/* 181 */             agg_holder.reset(); //TODO: investigate if reset or zeroout are actually needed
/* 182 */             agg_rowWriter.zeroOutNullBytes();
/* 183 */             agg_rowWriter.write(0, agg_key);
/* 184 */             agg_rowWriter.write(1, agg_key1);
/* 185 */             agg_rowWriter.write(2, agg_key2);
/* 186 */             agg_rowWriter.write(3, agg_key3);
/* 187 */             agg_rowWriter.write(4, agg_key4);
/* 188 */             agg_rowWriter.write(5, agg_key5);
/* 189 */             agg_result.setTotalSize(agg_holder.totalSize());
/* 190 */             Object kbase = agg_result.getBaseObject();
/* 191 */             long koff = agg_result.getBaseOffset();
/* 192 */             int klen = agg_result.getSizeInBytes();
/* 193 */
/* 194 */             UnsafeRow vRow
/* 195 */             = batch.appendRow(kbase, koff, klen, emptyVBase, emptyVOff, emptyVLen);
/* 196 */             if (vRow == null) {
/* 197 */               isBatchFull = true;
/* 198 */             } else {
/* 199 */               buckets[idx] = numRows++;
/* 200 */             }
/* 201 */             return vRow;
/* 202 */           } else {
/* 203 */             // No more space
/* 204 */             return null;
/* 205 */           }
/* 206 */         } else if (equals(idx, agg_key, agg_key1, agg_key2, agg_key3, agg_key4, agg_key5)) {
/* 207 */           return batch.getValueRow(buckets[idx]);
/* 208 */         }
/* 209 */         idx = (idx + 1) & (numBuckets - 1);
/* 210 */         step++;
/* 211 */       }
/* 212 */       // Didn't find it
/* 213 */       return null;
/* 214 */     }
/* 215 */
/* 216 */     private boolean equals(int idx, UTF8String agg_key, UTF8String agg_key1, UTF8String agg_key2, int agg_key3, int agg_key4, int agg_key5) {
/* 217 */       UnsafeRow row = batch.getKeyRow(buckets[idx]);
/* 218 */       return (row.getUTF8String(0).equals(agg_key)) && (row.getUTF8String(1).equals(agg_key1)) && (row.getUTF8String(2).equals(agg_key2)) && (row.getInt(3) == agg_key3) && (row.getInt(4) == agg_key4) && (row.getInt(5) == agg_key5);
/* 219 */     }
/* 220 */
/* 221 */     private long hash(UTF8String agg_key, UTF8String agg_key1, UTF8String agg_key2, int agg_key3, int agg_key4, int agg_key5) {
/* 222 */       long agg_hash = 0;
/* 223 */
/* 224 */       int agg_result = 0;
/* 225 */       byte[] agg_bytes = agg_key.getBytes();
/* 226 */       for (int i = 0; i < agg_bytes.length; i++) {
/* 227 */         int agg_hash1 = agg_bytes[i];
/* 228 */         agg_result = (agg_result ^ (0x9e3779b9)) + agg_hash1 + (agg_result << 6) + (agg_result >>> 2);
/* 229 */       }
/* 230 */
/* 231 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result + (agg_hash << 6) + (agg_hash >>> 2);
/* 232 */
/* 233 */       int agg_result1 = 0;
/* 234 */       byte[] agg_bytes1 = agg_key1.getBytes();
/* 235 */       for (int i = 0; i < agg_bytes1.length; i++) {
/* 236 */         int agg_hash2 = agg_bytes1[i];
/* 237 */         agg_result1 = (agg_result1 ^ (0x9e3779b9)) + agg_hash2 + (agg_result1 << 6) + (agg_result1 >>> 2);
/* 238 */       }
/* 239 */
/* 240 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result1 + (agg_hash << 6) + (agg_hash >>> 2);
/* 241 */
/* 242 */       int agg_result2 = 0;
/* 243 */       byte[] agg_bytes2 = agg_key2.getBytes();
/* 244 */       for (int i = 0; i < agg_bytes2.length; i++) {
/* 245 */         int agg_hash3 = agg_bytes2[i];
/* 246 */         agg_result2 = (agg_result2 ^ (0x9e3779b9)) + agg_hash3 + (agg_result2 << 6) + (agg_result2 >>> 2);
/* 247 */       }
/* 248 */
/* 249 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result2 + (agg_hash << 6) + (agg_hash >>> 2);
/* 250 */
/* 251 */       int agg_result3 = agg_key3;
/* 252 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result3 + (agg_hash << 6) + (agg_hash >>> 2);
/* 253 */
/* 254 */       int agg_result4 = agg_key4;
/* 255 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result4 + (agg_hash << 6) + (agg_hash >>> 2);
/* 256 */
/* 257 */       int agg_result5 = agg_key5;
/* 258 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result5 + (agg_hash << 6) + (agg_hash >>> 2);
/* 259 */
/* 260 */       return agg_hash;
/* 261 */     }
/* 262 */
/* 263 */     public org.apache.spark.unsafe.KVIterator<UnsafeRow, UnsafeRow> rowIterator() {
/* 264 */       return batch.rowIterator();
/* 265 */     }
/* 266 */
/* 267 */     public void close() {
/* 268 */       batch.close();
/* 269 */     }
/* 270 */
/* 271 */   }
/* 272 */
/* 273 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 274 */     agg_hashMap = agg_plan.createHashMap();
/* 275 */
/* 276 */     while (inputadapter_input.hasNext() && !stopEarly()) {
/* 277 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 278 */       boolean inputadapter_value18 = inputadapter_row.getBoolean(18);
/* 279 */       boolean inputadapter_value19 = inputadapter_row.getBoolean(19);
/* 280 */
/* 281 */       boolean filter_value = true;
/* 282 */
/* 283 */       if (!inputadapter_value18) {
/* 284 */         filter_value = inputadapter_value19;
/* 285 */       }
/* 286 */       if (!filter_value) continue;
/* 287 */
/* 288 */       filter_numOutputRows.add(1);
/* 289 */
/* 290 */       boolean inputadapter_isNull4 = inputadapter_row.isNullAt(4);
/* 291 */       int inputadapter_value4 = inputadapter_isNull4 ? -1 : (inputadapter_row.getInt(4));
/* 292 */
/* 293 */       // generate join key for stream side
/* 294 */
/* 295 */       boolean bhj_isNull = inputadapter_isNull4;
/* 296 */       long bhj_value = -1L;
/* 297 */       if (!inputadapter_isNull4) {
/* 298 */         bhj_value = (long) inputadapter_value4;
/* 299 */       }
/* 300 */       // find matches from HashedRelation
/* 301 */       UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 302 */       if (bhj_matched == null) continue;
/* 303 */
/* 304 */       bhj_numOutputRows.add(1);
/* 305 */
/* 306 */       boolean inputadapter_isNull2 = inputadapter_row.isNullAt(2);
/* 307 */       int inputadapter_value2 = inputadapter_isNull2 ? -1 : (inputadapter_row.getInt(2));
/* 308 */
/* 309 */       // generate join key for stream side
/* 310 */
/* 311 */       boolean bhj_isNull8 = inputadapter_isNull2;
/* 312 */       long bhj_value8 = -1L;
/* 313 */       if (!inputadapter_isNull2) {
/* 314 */         bhj_value8 = (long) inputadapter_value2;
/* 315 */       }
/* 316 */       // find matches from HashedRelation
/* 317 */       UnsafeRow bhj_matched1 = bhj_isNull8 ? null: (UnsafeRow)bhj_relation1.getValue(bhj_value8);
/* 318 */       if (bhj_matched1 == null) continue;
/* 319 */
/* 320 */       bhj_numOutputRows1.add(1);
/* 321 */
/* 322 */       boolean bhj_isNull3 = bhj_matched.isNullAt(1);
/* 323 */       UTF8String bhj_value3 = bhj_isNull3 ? null : (bhj_matched.getUTF8String(1));
/* 324 */       boolean bhj_isNull11 = bhj_matched1.isNullAt(1);
/* 325 */       UTF8String bhj_value11 = bhj_isNull11 ? null : (bhj_matched1.getUTF8String(1));
/* 326 */       boolean bhj_isNull12 = bhj_matched1.isNullAt(2);
/* 327 */       UTF8String bhj_value12 = bhj_isNull12 ? null : (bhj_matched1.getUTF8String(2));
/* 328 */       boolean bhj_isNull13 = bhj_matched1.isNullAt(3);
/* 329 */       int bhj_value13 = bhj_isNull13 ? -1 : (bhj_matched1.getInt(3));
/* 330 */       boolean bhj_isNull14 = bhj_matched1.isNullAt(4);
/* 331 */       int bhj_value14 = bhj_isNull14 ? -1 : (bhj_matched1.getInt(4));
/* 332 */       boolean bhj_isNull15 = bhj_matched1.isNullAt(5);
/* 333 */       int bhj_value15 = bhj_isNull15 ? -1 : (bhj_matched1.getInt(5));
/* 334 */
/* 335 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 336 */
/* 337 */       UnsafeRow agg_fastAggBuffer = null;
/* 338 */
/* 339 */       if (true) {
/* 340 */         if (!bhj_isNull3 && !bhj_isNull11 && !bhj_isNull12 && !bhj_isNull13 && !bhj_isNull14 && !bhj_isNull15) {
/* 341 */           agg_fastAggBuffer = agg_fastHashMap.findOrInsert(
/* 342 */             bhj_value3, bhj_value11, bhj_value12, bhj_value13, bhj_value14, bhj_value15);
/* 343 */         }
/* 344 */       }
/* 345 */
/* 346 */       if (agg_fastAggBuffer == null) {
/* 347 */         // generate grouping key
/* 348 */         agg_holder.reset();
/* 349 */
/* 350 */         agg_rowWriter.zeroOutNullBytes();
/* 351 */
/* 352 */         if (bhj_isNull3) {
/* 353 */           agg_rowWriter.setNullAt(0);
/* 354 */         } else {
/* 355 */           agg_rowWriter.write(0, bhj_value3);
/* 356 */         }
/* 357 */
/* 358 */         if (bhj_isNull11) {
/* 359 */           agg_rowWriter.setNullAt(1);
/* 360 */         } else {
/* 361 */           agg_rowWriter.write(1, bhj_value11);
/* 362 */         }
/* 363 */
/* 364 */         if (bhj_isNull12) {
/* 365 */           agg_rowWriter.setNullAt(2);
/* 366 */         } else {
/* 367 */           agg_rowWriter.write(2, bhj_value12);
/* 368 */         }
/* 369 */
/* 370 */         if (bhj_isNull13) {
/* 371 */           agg_rowWriter.setNullAt(3);
/* 372 */         } else {
/* 373 */           agg_rowWriter.write(3, bhj_value13);
/* 374 */         }
/* 375 */
/* 376 */         if (bhj_isNull14) {
/* 377 */           agg_rowWriter.setNullAt(4);
/* 378 */         } else {
/* 379 */           agg_rowWriter.write(4, bhj_value14);
/* 380 */         }
/* 381 */
/* 382 */         if (bhj_isNull15) {
/* 383 */           agg_rowWriter.setNullAt(5);
/* 384 */         } else {
/* 385 */           agg_rowWriter.write(5, bhj_value15);
/* 386 */         }
/* 387 */         agg_result6.setTotalSize(agg_holder.totalSize());
/* 388 */         agg_value45 = 42;
/* 389 */
/* 390 */         if (!bhj_isNull3) {
/* 391 */           agg_value45 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value3.getBaseObject(), bhj_value3.getBaseOffset(), bhj_value3.numBytes(), agg_value45);
/* 392 */         }
/* 393 */
/* 394 */         if (!bhj_isNull11) {
/* 395 */           agg_value45 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value11.getBaseObject(), bhj_value11.getBaseOffset(), bhj_value11.numBytes(), agg_value45);
/* 396 */         }
/* 397 */
/* 398 */         if (!bhj_isNull12) {
/* 399 */           agg_value45 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value12.getBaseObject(), bhj_value12.getBaseOffset(), bhj_value12.numBytes(), agg_value45);
/* 400 */         }
/* 401 */
/* 402 */         if (!bhj_isNull13) {
/* 403 */           agg_value45 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(bhj_value13, agg_value45);
/* 404 */         }
/* 405 */
/* 406 */         if (!bhj_isNull14) {
/* 407 */           agg_value45 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(bhj_value14, agg_value45);
/* 408 */         }
/* 409 */
/* 410 */         if (!bhj_isNull15) {
/* 411 */           agg_value45 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(bhj_value15, agg_value45);
/* 412 */         }
/* 413 */         if (true) {
/* 414 */           // try to get the buffer from hash map
/* 415 */           agg_unsafeRowAggBuffer =
/* 416 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result6, agg_value45);
/* 417 */         }
/* 418 */         if (agg_unsafeRowAggBuffer == null) {
/* 419 */           if (agg_sorter == null) {
/* 420 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 421 */           } else {
/* 422 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 423 */           }
/* 424 */
/* 425 */           // the hash map had be spilled, it should have enough memory now,
/* 426 */           // try  to allocate buffer again.
/* 427 */           agg_unsafeRowAggBuffer =
/* 428 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result6, agg_value45);
/* 429 */           if (agg_unsafeRowAggBuffer == null) {
/* 430 */             // failed to allocate the first page
/* 431 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 432 */           }
/* 433 */         }
/* 434 */       }
/* 435 */
/* 436 */       if (agg_fastAggBuffer != null) {
/* 437 */         // update fast row
/* 438 */
/* 439 */         // common sub-expressions
/* 440 */         boolean agg_isNull106 = bhj_isNull15;
/* 441 */         long agg_value121 = -1L;
/* 442 */         if (!bhj_isNull15) {
/* 443 */           agg_value121 = (long) bhj_value15;
/* 444 */         }
/* 445 */         boolean agg_isNull108 = bhj_isNull13;
/* 446 */         long agg_value123 = -1L;
/* 447 */         if (!bhj_isNull13) {
/* 448 */           agg_value123 = (long) bhj_value13;
/* 449 */         }
/* 450 */         boolean agg_isNull110 = bhj_isNull14;
/* 451 */         long agg_value125 = -1L;
/* 452 */         if (!bhj_isNull14) {
/* 453 */           agg_value125 = (long) bhj_value14;
/* 454 */         }
/* 455 */         // evaluate aggregate function
/* 456 */         boolean agg_isNull112 = false;
/* 457 */
/* 458 */         long agg_value128 = agg_fastAggBuffer.getLong(0);
/* 459 */
/* 460 */         long agg_value127 = -1L;
/* 461 */         agg_value127 = agg_value128 + 1L;
/* 462 */         boolean agg_isNull116 = agg_fastAggBuffer.isNullAt(1);
/* 463 */         int agg_value131 = agg_isNull116 ? -1 : (agg_fastAggBuffer.getInt(1));
/* 464 */         boolean agg_isNull115 = agg_isNull116;
/* 465 */         int agg_value130 = agg_value131;
/* 466 */
/* 467 */         if (!bhj_isNull13 && (agg_isNull115 ||
/* 468 */             agg_value130 > bhj_value13)) {
/* 469 */           agg_isNull115 = false;
/* 470 */           agg_value130 = bhj_value13;
/* 471 */         }
/* 472 */         boolean agg_isNull119 = agg_fastAggBuffer.isNullAt(2);
/* 473 */         int agg_value134 = agg_isNull119 ? -1 : (agg_fastAggBuffer.getInt(2));
/* 474 */         boolean agg_isNull118 = agg_isNull119;
/* 475 */         int agg_value133 = agg_value134;
/* 476 */
/* 477 */         if (!bhj_isNull13 && (agg_isNull118 ||
/* 478 */             bhj_value13 > agg_value133)) {
/* 479 */           agg_isNull118 = false;
/* 480 */           agg_value133 = bhj_value13;
/* 481 */         }
/* 482 */         boolean agg_isNull121 = true;
/* 483 */         double agg_value136 = -1.0;
/* 484 */
/* 485 */         boolean agg_isNull122 = agg_fastAggBuffer.isNullAt(3);
/* 486 */         double agg_value137 = agg_isNull122 ? -1.0 : (agg_fastAggBuffer.getDouble(3));
/* 487 */         if (!agg_isNull122) {
/* 488 */           boolean agg_isNull124 = agg_isNull108;
/* 489 */           double agg_value139 = -1.0;
/* 490 */           if (!agg_isNull108) {
/* 491 */             agg_value139 = (double) agg_value123;
/* 492 */           }
/* 493 */           boolean agg_isNull123 = agg_isNull124;
/* 494 */           double agg_value138 = agg_value139;
/* 495 */           if (agg_isNull123) {
/* 496 */             boolean agg_isNull125 = false;
/* 497 */             double agg_value140 = -1.0;
/* 498 */             if (!false) {
/* 499 */               agg_value140 = (double) 0;
/* 500 */             }
/* 501 */             if (!agg_isNull125) {
/* 502 */               agg_isNull123 = false;
/* 503 */               agg_value138 = agg_value140;
/* 504 */             }
/* 505 */           }
/* 506 */
/* 507 */           agg_isNull121 = false; // resultCode could change nullability.
/* 508 */           agg_value136 = agg_value137 + agg_value138;
/* 509 */
/* 510 */         }
/* 511 */         boolean agg_isNull127 = false;
/* 512 */         long agg_value142 = -1L;
/* 513 */         if (!false && agg_isNull108) {
/* 514 */           boolean agg_isNull129 = agg_fastAggBuffer.isNullAt(4);
/* 515 */           long agg_value144 = agg_isNull129 ? -1L : (agg_fastAggBuffer.getLong(4));
/* 516 */           agg_isNull127 = agg_isNull129;
/* 517 */           agg_value142 = agg_value144;
/* 518 */         } else {
/* 519 */           boolean agg_isNull130 = true;
/* 520 */           long agg_value145 = -1L;
/* 521 */
/* 522 */           boolean agg_isNull131 = agg_fastAggBuffer.isNullAt(4);
/* 523 */           long agg_value146 = agg_isNull131 ? -1L : (agg_fastAggBuffer.getLong(4));
/* 524 */           if (!agg_isNull131) {
/* 525 */             agg_isNull130 = false; // resultCode could change nullability.
/* 526 */             agg_value145 = agg_value146 + 1L;
/* 527 */
/* 528 */           }
/* 529 */           agg_isNull127 = agg_isNull130;
/* 530 */           agg_value142 = agg_value145;
/* 531 */         }
/* 532 */         boolean agg_isNull133 = false;
/* 533 */
/* 534 */         long agg_value149 = agg_fastAggBuffer.getLong(5);
/* 535 */
/* 536 */         long agg_value148 = -1L;
/* 537 */         agg_value148 = agg_value149 + 1L;
/* 538 */         boolean agg_isNull137 = agg_fastAggBuffer.isNullAt(6);
/* 539 */         int agg_value152 = agg_isNull137 ? -1 : (agg_fastAggBuffer.getInt(6));
/* 540 */         boolean agg_isNull136 = agg_isNull137;
/* 541 */         int agg_value151 = agg_value152;
/* 542 */
/* 543 */         if (!bhj_isNull14 && (agg_isNull136 ||
/* 544 */             agg_value151 > bhj_value14)) {
/* 545 */           agg_isNull136 = false;
/* 546 */           agg_value151 = bhj_value14;
/* 547 */         }
/* 548 */         boolean agg_isNull140 = agg_fastAggBuffer.isNullAt(7);
/* 549 */         int agg_value155 = agg_isNull140 ? -1 : (agg_fastAggBuffer.getInt(7));
/* 550 */         boolean agg_isNull139 = agg_isNull140;
/* 551 */         int agg_value154 = agg_value155;
/* 552 */
/* 553 */         if (!bhj_isNull14 && (agg_isNull139 ||
/* 554 */             bhj_value14 > agg_value154)) {
/* 555 */           agg_isNull139 = false;
/* 556 */           agg_value154 = bhj_value14;
/* 557 */         }
/* 558 */         boolean agg_isNull142 = true;
/* 559 */         double agg_value157 = -1.0;
/* 560 */
/* 561 */         boolean agg_isNull143 = agg_fastAggBuffer.isNullAt(8);
/* 562 */         double agg_value158 = agg_isNull143 ? -1.0 : (agg_fastAggBuffer.getDouble(8));
/* 563 */         if (!agg_isNull143) {
/* 564 */           boolean agg_isNull145 = agg_isNull110;
/* 565 */           double agg_value160 = -1.0;
/* 566 */           if (!agg_isNull110) {
/* 567 */             agg_value160 = (double) agg_value125;
/* 568 */           }
/* 569 */           boolean agg_isNull144 = agg_isNull145;
/* 570 */           double agg_value159 = agg_value160;
/* 571 */           if (agg_isNull144) {
/* 572 */             boolean agg_isNull146 = false;
/* 573 */             double agg_value161 = -1.0;
/* 574 */             if (!false) {
/* 575 */               agg_value161 = (double) 0;
/* 576 */             }
/* 577 */             if (!agg_isNull146) {
/* 578 */               agg_isNull144 = false;
/* 579 */               agg_value159 = agg_value161;
/* 580 */             }
/* 581 */           }
/* 582 */
/* 583 */           agg_isNull142 = false; // resultCode could change nullability.
/* 584 */           agg_value157 = agg_value158 + agg_value159;
/* 585 */
/* 586 */         }
/* 587 */         boolean agg_isNull148 = false;
/* 588 */         long agg_value163 = -1L;
/* 589 */         if (!false && agg_isNull110) {
/* 590 */           boolean agg_isNull150 = agg_fastAggBuffer.isNullAt(9);
/* 591 */           long agg_value165 = agg_isNull150 ? -1L : (agg_fastAggBuffer.getLong(9));
/* 592 */           agg_isNull148 = agg_isNull150;
/* 593 */           agg_value163 = agg_value165;
/* 594 */         } else {
/* 595 */           boolean agg_isNull151 = true;
/* 596 */           long agg_value166 = -1L;
/* 597 */
/* 598 */           boolean agg_isNull152 = agg_fastAggBuffer.isNullAt(9);
/* 599 */           long agg_value167 = agg_isNull152 ? -1L : (agg_fastAggBuffer.getLong(9));
/* 600 */           if (!agg_isNull152) {
/* 601 */             agg_isNull151 = false; // resultCode could change nullability.
/* 602 */             agg_value166 = agg_value167 + 1L;
/* 603 */
/* 604 */           }
/* 605 */           agg_isNull148 = agg_isNull151;
/* 606 */           agg_value163 = agg_value166;
/* 607 */         }
/* 608 */         boolean agg_isNull154 = false;
/* 609 */
/* 610 */         long agg_value170 = agg_fastAggBuffer.getLong(10);
/* 611 */
/* 612 */         long agg_value169 = -1L;
/* 613 */         agg_value169 = agg_value170 + 1L;
/* 614 */         boolean agg_isNull158 = agg_fastAggBuffer.isNullAt(11);
/* 615 */         int agg_value173 = agg_isNull158 ? -1 : (agg_fastAggBuffer.getInt(11));
/* 616 */         boolean agg_isNull157 = agg_isNull158;
/* 617 */         int agg_value172 = agg_value173;
/* 618 */
/* 619 */         if (!bhj_isNull15 && (agg_isNull157 ||
/* 620 */             agg_value172 > bhj_value15)) {
/* 621 */           agg_isNull157 = false;
/* 622 */           agg_value172 = bhj_value15;
/* 623 */         }
/* 624 */         boolean agg_isNull161 = agg_fastAggBuffer.isNullAt(12);
/* 625 */         int agg_value176 = agg_isNull161 ? -1 : (agg_fastAggBuffer.getInt(12));
/* 626 */         boolean agg_isNull160 = agg_isNull161;
/* 627 */         int agg_value175 = agg_value176;
/* 628 */
/* 629 */         if (!bhj_isNull15 && (agg_isNull160 ||
/* 630 */             bhj_value15 > agg_value175)) {
/* 631 */           agg_isNull160 = false;
/* 632 */           agg_value175 = bhj_value15;
/* 633 */         }
/* 634 */         boolean agg_isNull163 = true;
/* 635 */         double agg_value178 = -1.0;
/* 636 */
/* 637 */         boolean agg_isNull164 = agg_fastAggBuffer.isNullAt(13);
/* 638 */         double agg_value179 = agg_isNull164 ? -1.0 : (agg_fastAggBuffer.getDouble(13));
/* 639 */         if (!agg_isNull164) {
/* 640 */           boolean agg_isNull166 = agg_isNull106;
/* 641 */           double agg_value181 = -1.0;
/* 642 */           if (!agg_isNull106) {
/* 643 */             agg_value181 = (double) agg_value121;
/* 644 */           }
/* 645 */           boolean agg_isNull165 = agg_isNull166;
/* 646 */           double agg_value180 = agg_value181;
/* 647 */           if (agg_isNull165) {
/* 648 */             boolean agg_isNull167 = false;
/* 649 */             double agg_value182 = -1.0;
/* 650 */             if (!false) {
/* 651 */               agg_value182 = (double) 0;
/* 652 */             }
/* 653 */             if (!agg_isNull167) {
/* 654 */               agg_isNull165 = false;
/* 655 */               agg_value180 = agg_value182;
/* 656 */             }
/* 657 */           }
/* 658 */
/* 659 */           agg_isNull163 = false; // resultCode could change nullability.
/* 660 */           agg_value178 = agg_value179 + agg_value180;
/* 661 */
/* 662 */         }
/* 663 */         boolean agg_isNull169 = false;
/* 664 */         long agg_value184 = -1L;
/* 665 */         if (!false && agg_isNull106) {
/* 666 */           boolean agg_isNull171 = agg_fastAggBuffer.isNullAt(14);
/* 667 */           long agg_value186 = agg_isNull171 ? -1L : (agg_fastAggBuffer.getLong(14));
/* 668 */           agg_isNull169 = agg_isNull171;
/* 669 */           agg_value184 = agg_value186;
/* 670 */         } else {
/* 671 */           boolean agg_isNull172 = true;
/* 672 */           long agg_value187 = -1L;
/* 673 */
/* 674 */           boolean agg_isNull173 = agg_fastAggBuffer.isNullAt(14);
/* 675 */           long agg_value188 = agg_isNull173 ? -1L : (agg_fastAggBuffer.getLong(14));
/* 676 */           if (!agg_isNull173) {
/* 677 */             agg_isNull172 = false; // resultCode could change nullability.
/* 678 */             agg_value187 = agg_value188 + 1L;
/* 679 */
/* 680 */           }
/* 681 */           agg_isNull169 = agg_isNull172;
/* 682 */           agg_value184 = agg_value187;
/* 683 */         }
/* 684 */         // update fast row
/* 685 */         agg_fastAggBuffer.setLong(0, agg_value127);
/* 686 */
/* 687 */         if (!agg_isNull115) {
/* 688 */           agg_fastAggBuffer.setInt(1, agg_value130);
/* 689 */         } else {
/* 690 */           agg_fastAggBuffer.setNullAt(1);
/* 691 */         }
/* 692 */
/* 693 */         if (!agg_isNull118) {
/* 694 */           agg_fastAggBuffer.setInt(2, agg_value133);
/* 695 */         } else {
/* 696 */           agg_fastAggBuffer.setNullAt(2);
/* 697 */         }
/* 698 */
/* 699 */         if (!agg_isNull121) {
/* 700 */           agg_fastAggBuffer.setDouble(3, agg_value136);
/* 701 */         } else {
/* 702 */           agg_fastAggBuffer.setNullAt(3);
/* 703 */         }
/* 704 */
/* 705 */         if (!agg_isNull127) {
/* 706 */           agg_fastAggBuffer.setLong(4, agg_value142);
/* 707 */         } else {
/* 708 */           agg_fastAggBuffer.setNullAt(4);
/* 709 */         }
/* 710 */
/* 711 */         agg_fastAggBuffer.setLong(5, agg_value148);
/* 712 */
/* 713 */         if (!agg_isNull136) {
/* 714 */           agg_fastAggBuffer.setInt(6, agg_value151);
/* 715 */         } else {
/* 716 */           agg_fastAggBuffer.setNullAt(6);
/* 717 */         }
/* 718 */
/* 719 */         if (!agg_isNull139) {
/* 720 */           agg_fastAggBuffer.setInt(7, agg_value154);
/* 721 */         } else {
/* 722 */           agg_fastAggBuffer.setNullAt(7);
/* 723 */         }
/* 724 */
/* 725 */         if (!agg_isNull142) {
/* 726 */           agg_fastAggBuffer.setDouble(8, agg_value157);
/* 727 */         } else {
/* 728 */           agg_fastAggBuffer.setNullAt(8);
/* 729 */         }
/* 730 */
/* 731 */         if (!agg_isNull148) {
/* 732 */           agg_fastAggBuffer.setLong(9, agg_value163);
/* 733 */         } else {
/* 734 */           agg_fastAggBuffer.setNullAt(9);
/* 735 */         }
/* 736 */
/* 737 */         agg_fastAggBuffer.setLong(10, agg_value169);
/* 738 */
/* 739 */         if (!agg_isNull157) {
/* 740 */           agg_fastAggBuffer.setInt(11, agg_value172);
/* 741 */         } else {
/* 742 */           agg_fastAggBuffer.setNullAt(11);
/* 743 */         }
/* 744 */
/* 745 */         if (!agg_isNull160) {
/* 746 */           agg_fastAggBuffer.setInt(12, agg_value175);
/* 747 */         } else {
/* 748 */           agg_fastAggBuffer.setNullAt(12);
/* 749 */         }
/* 750 */
/* 751 */         if (!agg_isNull163) {
/* 752 */           agg_fastAggBuffer.setDouble(13, agg_value178);
/* 753 */         } else {
/* 754 */           agg_fastAggBuffer.setNullAt(13);
/* 755 */         }
/* 756 */
/* 757 */         if (!agg_isNull169) {
/* 758 */           agg_fastAggBuffer.setLong(14, agg_value184);
/* 759 */         } else {
/* 760 */           agg_fastAggBuffer.setNullAt(14);
/* 761 */         }
/* 762 */
/* 763 */       } else {
/* 764 */         // update unsafe row
/* 765 */
/* 766 */         // common sub-expressions
/* 767 */         boolean agg_isNull37 = bhj_isNull15;
/* 768 */         long agg_value52 = -1L;
/* 769 */         if (!bhj_isNull15) {
/* 770 */           agg_value52 = (long) bhj_value15;
/* 771 */         }
/* 772 */         boolean agg_isNull39 = bhj_isNull13;
/* 773 */         long agg_value54 = -1L;
/* 774 */         if (!bhj_isNull13) {
/* 775 */           agg_value54 = (long) bhj_value13;
/* 776 */         }
/* 777 */         boolean agg_isNull41 = bhj_isNull14;
/* 778 */         long agg_value56 = -1L;
/* 779 */         if (!bhj_isNull14) {
/* 780 */           agg_value56 = (long) bhj_value14;
/* 781 */         }
/* 782 */         // evaluate aggregate function
/* 783 */         boolean agg_isNull43 = false;
/* 784 */
/* 785 */         long agg_value59 = agg_unsafeRowAggBuffer.getLong(0);
/* 786 */
/* 787 */         long agg_value58 = -1L;
/* 788 */         agg_value58 = agg_value59 + 1L;
/* 789 */         boolean agg_isNull47 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 790 */         int agg_value62 = agg_isNull47 ? -1 : (agg_unsafeRowAggBuffer.getInt(1));
/* 791 */         boolean agg_isNull46 = agg_isNull47;
/* 792 */         int agg_value61 = agg_value62;
/* 793 */
/* 794 */         if (!bhj_isNull13 && (agg_isNull46 ||
/* 795 */             agg_value61 > bhj_value13)) {
/* 796 */           agg_isNull46 = false;
/* 797 */           agg_value61 = bhj_value13;
/* 798 */         }
/* 799 */         boolean agg_isNull50 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 800 */         int agg_value65 = agg_isNull50 ? -1 : (agg_unsafeRowAggBuffer.getInt(2));
/* 801 */         boolean agg_isNull49 = agg_isNull50;
/* 802 */         int agg_value64 = agg_value65;
/* 803 */
/* 804 */         if (!bhj_isNull13 && (agg_isNull49 ||
/* 805 */             bhj_value13 > agg_value64)) {
/* 806 */           agg_isNull49 = false;
/* 807 */           agg_value64 = bhj_value13;
/* 808 */         }
/* 809 */         boolean agg_isNull52 = true;
/* 810 */         double agg_value67 = -1.0;
/* 811 */
/* 812 */         boolean agg_isNull53 = agg_unsafeRowAggBuffer.isNullAt(3);
/* 813 */         double agg_value68 = agg_isNull53 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(3));
/* 814 */         if (!agg_isNull53) {
/* 815 */           boolean agg_isNull55 = agg_isNull39;
/* 816 */           double agg_value70 = -1.0;
/* 817 */           if (!agg_isNull39) {
/* 818 */             agg_value70 = (double) agg_value54;
/* 819 */           }
/* 820 */           boolean agg_isNull54 = agg_isNull55;
/* 821 */           double agg_value69 = agg_value70;
/* 822 */           if (agg_isNull54) {
/* 823 */             boolean agg_isNull56 = false;
/* 824 */             double agg_value71 = -1.0;
/* 825 */             if (!false) {
/* 826 */               agg_value71 = (double) 0;
/* 827 */             }
/* 828 */             if (!agg_isNull56) {
/* 829 */               agg_isNull54 = false;
/* 830 */               agg_value69 = agg_value71;
/* 831 */             }
/* 832 */           }
/* 833 */
/* 834 */           agg_isNull52 = false; // resultCode could change nullability.
/* 835 */           agg_value67 = agg_value68 + agg_value69;
/* 836 */
/* 837 */         }
/* 838 */         boolean agg_isNull58 = false;
/* 839 */         long agg_value73 = -1L;
/* 840 */         if (!false && agg_isNull39) {
/* 841 */           boolean agg_isNull60 = agg_unsafeRowAggBuffer.isNullAt(4);
/* 842 */           long agg_value75 = agg_isNull60 ? -1L : (agg_unsafeRowAggBuffer.getLong(4));
/* 843 */           agg_isNull58 = agg_isNull60;
/* 844 */           agg_value73 = agg_value75;
/* 845 */         } else {
/* 846 */           boolean agg_isNull61 = true;
/* 847 */           long agg_value76 = -1L;
/* 848 */
/* 849 */           boolean agg_isNull62 = agg_unsafeRowAggBuffer.isNullAt(4);
/* 850 */           long agg_value77 = agg_isNull62 ? -1L : (agg_unsafeRowAggBuffer.getLong(4));
/* 851 */           if (!agg_isNull62) {
/* 852 */             agg_isNull61 = false; // resultCode could change nullability.
/* 853 */             agg_value76 = agg_value77 + 1L;
/* 854 */
/* 855 */           }
/* 856 */           agg_isNull58 = agg_isNull61;
/* 857 */           agg_value73 = agg_value76;
/* 858 */         }
/* 859 */         boolean agg_isNull64 = false;
/* 860 */
/* 861 */         long agg_value80 = agg_unsafeRowAggBuffer.getLong(5);
/* 862 */
/* 863 */         long agg_value79 = -1L;
/* 864 */         agg_value79 = agg_value80 + 1L;
/* 865 */         boolean agg_isNull68 = agg_unsafeRowAggBuffer.isNullAt(6);
/* 866 */         int agg_value83 = agg_isNull68 ? -1 : (agg_unsafeRowAggBuffer.getInt(6));
/* 867 */         boolean agg_isNull67 = agg_isNull68;
/* 868 */         int agg_value82 = agg_value83;
/* 869 */
/* 870 */         if (!bhj_isNull14 && (agg_isNull67 ||
/* 871 */             agg_value82 > bhj_value14)) {
/* 872 */           agg_isNull67 = false;
/* 873 */           agg_value82 = bhj_value14;
/* 874 */         }
/* 875 */         boolean agg_isNull71 = agg_unsafeRowAggBuffer.isNullAt(7);
/* 876 */         int agg_value86 = agg_isNull71 ? -1 : (agg_unsafeRowAggBuffer.getInt(7));
/* 877 */         boolean agg_isNull70 = agg_isNull71;
/* 878 */         int agg_value85 = agg_value86;
/* 879 */
/* 880 */         if (!bhj_isNull14 && (agg_isNull70 ||
/* 881 */             bhj_value14 > agg_value85)) {
/* 882 */           agg_isNull70 = false;
/* 883 */           agg_value85 = bhj_value14;
/* 884 */         }
/* 885 */         boolean agg_isNull73 = true;
/* 886 */         double agg_value88 = -1.0;
/* 887 */
/* 888 */         boolean agg_isNull74 = agg_unsafeRowAggBuffer.isNullAt(8);
/* 889 */         double agg_value89 = agg_isNull74 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(8));
/* 890 */         if (!agg_isNull74) {
/* 891 */           boolean agg_isNull76 = agg_isNull41;
/* 892 */           double agg_value91 = -1.0;
/* 893 */           if (!agg_isNull41) {
/* 894 */             agg_value91 = (double) agg_value56;
/* 895 */           }
/* 896 */           boolean agg_isNull75 = agg_isNull76;
/* 897 */           double agg_value90 = agg_value91;
/* 898 */           if (agg_isNull75) {
/* 899 */             boolean agg_isNull77 = false;
/* 900 */             double agg_value92 = -1.0;
/* 901 */             if (!false) {
/* 902 */               agg_value92 = (double) 0;
/* 903 */             }
/* 904 */             if (!agg_isNull77) {
/* 905 */               agg_isNull75 = false;
/* 906 */               agg_value90 = agg_value92;
/* 907 */             }
/* 908 */           }
/* 909 */
/* 910 */           agg_isNull73 = false; // resultCode could change nullability.
/* 911 */           agg_value88 = agg_value89 + agg_value90;
/* 912 */
/* 913 */         }
/* 914 */         boolean agg_isNull79 = false;
/* 915 */         long agg_value94 = -1L;
/* 916 */         if (!false && agg_isNull41) {
/* 917 */           boolean agg_isNull81 = agg_unsafeRowAggBuffer.isNullAt(9);
/* 918 */           long agg_value96 = agg_isNull81 ? -1L : (agg_unsafeRowAggBuffer.getLong(9));
/* 919 */           agg_isNull79 = agg_isNull81;
/* 920 */           agg_value94 = agg_value96;
/* 921 */         } else {
/* 922 */           boolean agg_isNull82 = true;
/* 923 */           long agg_value97 = -1L;
/* 924 */
/* 925 */           boolean agg_isNull83 = agg_unsafeRowAggBuffer.isNullAt(9);
/* 926 */           long agg_value98 = agg_isNull83 ? -1L : (agg_unsafeRowAggBuffer.getLong(9));
/* 927 */           if (!agg_isNull83) {
/* 928 */             agg_isNull82 = false; // resultCode could change nullability.
/* 929 */             agg_value97 = agg_value98 + 1L;
/* 930 */
/* 931 */           }
/* 932 */           agg_isNull79 = agg_isNull82;
/* 933 */           agg_value94 = agg_value97;
/* 934 */         }
/* 935 */         boolean agg_isNull85 = false;
/* 936 */
/* 937 */         long agg_value101 = agg_unsafeRowAggBuffer.getLong(10);
/* 938 */
/* 939 */         long agg_value100 = -1L;
/* 940 */         agg_value100 = agg_value101 + 1L;
/* 941 */         boolean agg_isNull89 = agg_unsafeRowAggBuffer.isNullAt(11);
/* 942 */         int agg_value104 = agg_isNull89 ? -1 : (agg_unsafeRowAggBuffer.getInt(11));
/* 943 */         boolean agg_isNull88 = agg_isNull89;
/* 944 */         int agg_value103 = agg_value104;
/* 945 */
/* 946 */         if (!bhj_isNull15 && (agg_isNull88 ||
/* 947 */             agg_value103 > bhj_value15)) {
/* 948 */           agg_isNull88 = false;
/* 949 */           agg_value103 = bhj_value15;
/* 950 */         }
/* 951 */         boolean agg_isNull92 = agg_unsafeRowAggBuffer.isNullAt(12);
/* 952 */         int agg_value107 = agg_isNull92 ? -1 : (agg_unsafeRowAggBuffer.getInt(12));
/* 953 */         boolean agg_isNull91 = agg_isNull92;
/* 954 */         int agg_value106 = agg_value107;
/* 955 */
/* 956 */         if (!bhj_isNull15 && (agg_isNull91 ||
/* 957 */             bhj_value15 > agg_value106)) {
/* 958 */           agg_isNull91 = false;
/* 959 */           agg_value106 = bhj_value15;
/* 960 */         }
/* 961 */         boolean agg_isNull94 = true;
/* 962 */         double agg_value109 = -1.0;
/* 963 */
/* 964 */         boolean agg_isNull95 = agg_unsafeRowAggBuffer.isNullAt(13);
/* 965 */         double agg_value110 = agg_isNull95 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(13));
/* 966 */         if (!agg_isNull95) {
/* 967 */           boolean agg_isNull97 = agg_isNull37;
/* 968 */           double agg_value112 = -1.0;
/* 969 */           if (!agg_isNull37) {
/* 970 */             agg_value112 = (double) agg_value52;
/* 971 */           }
/* 972 */           boolean agg_isNull96 = agg_isNull97;
/* 973 */           double agg_value111 = agg_value112;
/* 974 */           if (agg_isNull96) {
/* 975 */             boolean agg_isNull98 = false;
/* 976 */             double agg_value113 = -1.0;
/* 977 */             if (!false) {
/* 978 */               agg_value113 = (double) 0;
/* 979 */             }
/* 980 */             if (!agg_isNull98) {
/* 981 */               agg_isNull96 = false;
/* 982 */               agg_value111 = agg_value113;
/* 983 */             }
/* 984 */           }
/* 985 */
/* 986 */           agg_isNull94 = false; // resultCode could change nullability.
/* 987 */           agg_value109 = agg_value110 + agg_value111;
/* 988 */
/* 989 */         }
/* 990 */         boolean agg_isNull100 = false;
/* 991 */         long agg_value115 = -1L;
/* 992 */         if (!false && agg_isNull37) {
/* 993 */           boolean agg_isNull102 = agg_unsafeRowAggBuffer.isNullAt(14);
/* 994 */           long agg_value117 = agg_isNull102 ? -1L : (agg_unsafeRowAggBuffer.getLong(14));
/* 995 */           agg_isNull100 = agg_isNull102;
/* 996 */           agg_value115 = agg_value117;
/* 997 */         } else {
/* 998 */           boolean agg_isNull103 = true;
/* 999 */           long agg_value118 = -1L;
/* 1000 */
/* 1001 */           boolean agg_isNull104 = agg_unsafeRowAggBuffer.isNullAt(14);
/* 1002 */           long agg_value119 = agg_isNull104 ? -1L : (agg_unsafeRowAggBuffer.getLong(14));
/* 1003 */           if (!agg_isNull104) {
/* 1004 */             agg_isNull103 = false; // resultCode could change nullability.
/* 1005 */             agg_value118 = agg_value119 + 1L;
/* 1006 */
/* 1007 */           }
/* 1008 */           agg_isNull100 = agg_isNull103;
/* 1009 */           agg_value115 = agg_value118;
/* 1010 */         }
/* 1011 */         // update unsafe row buffer
/* 1012 */         agg_unsafeRowAggBuffer.setLong(0, agg_value58);
/* 1013 */
/* 1014 */         if (!agg_isNull46) {
/* 1015 */           agg_unsafeRowAggBuffer.setInt(1, agg_value61);
/* 1016 */         } else {
/* 1017 */           agg_unsafeRowAggBuffer.setNullAt(1);
/* 1018 */         }
/* 1019 */
/* 1020 */         if (!agg_isNull49) {
/* 1021 */           agg_unsafeRowAggBuffer.setInt(2, agg_value64);
/* 1022 */         } else {
/* 1023 */           agg_unsafeRowAggBuffer.setNullAt(2);
/* 1024 */         }
/* 1025 */
/* 1026 */         if (!agg_isNull52) {
/* 1027 */           agg_unsafeRowAggBuffer.setDouble(3, agg_value67);
/* 1028 */         } else {
/* 1029 */           agg_unsafeRowAggBuffer.setNullAt(3);
/* 1030 */         }
/* 1031 */
/* 1032 */         if (!agg_isNull58) {
/* 1033 */           agg_unsafeRowAggBuffer.setLong(4, agg_value73);
/* 1034 */         } else {
/* 1035 */           agg_unsafeRowAggBuffer.setNullAt(4);
/* 1036 */         }
/* 1037 */
/* 1038 */         agg_unsafeRowAggBuffer.setLong(5, agg_value79);
/* 1039 */
/* 1040 */         if (!agg_isNull67) {
/* 1041 */           agg_unsafeRowAggBuffer.setInt(6, agg_value82);
/* 1042 */         } else {
/* 1043 */           agg_unsafeRowAggBuffer.setNullAt(6);
/* 1044 */         }
/* 1045 */
/* 1046 */         if (!agg_isNull70) {
/* 1047 */           agg_unsafeRowAggBuffer.setInt(7, agg_value85);
/* 1048 */         } else {
/* 1049 */           agg_unsafeRowAggBuffer.setNullAt(7);
/* 1050 */         }
/* 1051 */
/* 1052 */         if (!agg_isNull73) {
/* 1053 */           agg_unsafeRowAggBuffer.setDouble(8, agg_value88);
/* 1054 */         } else {
/* 1055 */           agg_unsafeRowAggBuffer.setNullAt(8);
/* 1056 */         }
/* 1057 */
/* 1058 */         if (!agg_isNull79) {
/* 1059 */           agg_unsafeRowAggBuffer.setLong(9, agg_value94);
/* 1060 */         } else {
/* 1061 */           agg_unsafeRowAggBuffer.setNullAt(9);
/* 1062 */         }
/* 1063 */
/* 1064 */         agg_unsafeRowAggBuffer.setLong(10, agg_value100);
/* 1065 */
/* 1066 */         if (!agg_isNull88) {
/* 1067 */           agg_unsafeRowAggBuffer.setInt(11, agg_value103);
/* 1068 */         } else {
/* 1069 */           agg_unsafeRowAggBuffer.setNullAt(11);
/* 1070 */         }
/* 1071 */
/* 1072 */         if (!agg_isNull91) {
/* 1073 */           agg_unsafeRowAggBuffer.setInt(12, agg_value106);
/* 1074 */         } else {
/* 1075 */           agg_unsafeRowAggBuffer.setNullAt(12);
/* 1076 */         }
/* 1077 */
/* 1078 */         if (!agg_isNull94) {
/* 1079 */           agg_unsafeRowAggBuffer.setDouble(13, agg_value109);
/* 1080 */         } else {
/* 1081 */           agg_unsafeRowAggBuffer.setNullAt(13);
/* 1082 */         }
/* 1083 */
/* 1084 */         if (!agg_isNull100) {
/* 1085 */           agg_unsafeRowAggBuffer.setLong(14, agg_value115);
/* 1086 */         } else {
/* 1087 */           agg_unsafeRowAggBuffer.setNullAt(14);
/* 1088 */         }
/* 1089 */
/* 1090 */       }
/* 1091 */       if (shouldStop()) return;
/* 1092 */     }
/* 1093 */
/* 1094 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 1095 */
/* 1096 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 1097 */   }
/* 1098 */
/* 1099 */   private void wholestagecodegen_init_2() {
/* 1100 */     this.bhj_numOutputRows1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[28];
/* 1101 */     bhj_result1 = new UnsafeRow(8);
/* 1102 */     this.bhj_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result1, 96);
/* 1103 */     this.bhj_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder1, 8);
/* 1104 */     project_result2 = new UnsafeRow(6);
/* 1105 */     this.project_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result2, 96);
/* 1106 */     this.project_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder2, 6);
/* 1107 */     agg_result6 = new UnsafeRow(6);
/* 1108 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result6, 96);
/* 1109 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 6);
/* 1110 */
/* 1111 */     agg_unsafeRowJoiner = agg_plan.createUnsafeJoiner();
/* 1112 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[29];
/* 1113 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[30];
/* 1114 */
/* 1115 */   }
/* 1116 */
/* 1117 */   private void wholestagecodegen_init_1() {
/* 1118 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[25];
/* 1119 */
/* 1120 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 1121 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 1122 */
/* 1123 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[26];
/* 1124 */     bhj_result = new UnsafeRow(4);
/* 1125 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 32);
/* 1126 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 4);
/* 1127 */     project_result1 = new UnsafeRow(2);
/* 1128 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 32);
/* 1129 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 2);
/* 1130 */     this.bhj_broadcast1 = (org.apache.spark.broadcast.TorrentBroadcast) references[27];
/* 1131 */
/* 1132 */     bhj_relation1 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast1.value()).asReadOnlyCopy();
/* 1133 */     incPeakExecutionMemory(bhj_relation1.estimatedSize());
/* 1134 */
/* 1135 */   }
/* 1136 */
/* 1137 */   protected void processNext() throws java.io.IOException {
/* 1138 */     if (!agg_initAgg) {
/* 1139 */       agg_initAgg = true;
/* 1140 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 1141 */       agg_doAggregateWithKeys();
/* 1142 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 1143 */     }
/* 1144 */
/* 1145 */     // output the result
/* 1146 */
/* 1147 */     while (agg_fastHashMapIter.next()) {
/* 1148 */       wholestagecodegen_numOutputRows.add(1);
/* 1149 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 1150 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 1151 */
/* 1152 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 1153 */
/* 1154 */       append(agg_resultRow);
/* 1155 */
/* 1156 */       if (shouldStop()) return;
/* 1157 */     }
/* 1158 */     agg_fastHashMap.close();
/* 1159 */
/* 1160 */     while (agg_mapIter.next()) {
/* 1161 */       wholestagecodegen_numOutputRows.add(1);
/* 1162 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 1163 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 1164 */
/* 1165 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 1166 */
/* 1167 */       append(agg_resultRow);
/* 1168 */
/* 1169 */       if (shouldStop()) return;
/* 1170 */     }
/* 1171 */
/* 1172 */     agg_mapIter.close();
/* 1173 */     if (agg_sorter == null) {
/* 1174 */       agg_hashMap.free();
/* 1175 */     }
/* 1176 */   }
/* 1177 */ }
