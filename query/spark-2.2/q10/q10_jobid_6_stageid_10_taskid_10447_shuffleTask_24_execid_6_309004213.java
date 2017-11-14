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
/* 015 */   private boolean agg_bufIsNull3;
/* 016 */   private long agg_bufValue3;
/* 017 */   private boolean agg_bufIsNull4;
/* 018 */   private long agg_bufValue4;
/* 019 */   private boolean agg_bufIsNull5;
/* 020 */   private long agg_bufValue5;
/* 021 */   private org.apache.spark.sql.execution.aggregate.HashAggregateExec agg_plan;
/* 022 */   private agg_FastHashMap agg_fastHashMap;
/* 023 */   private org.apache.spark.unsafe.KVIterator agg_fastHashMapIter;
/* 024 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap;
/* 025 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter;
/* 026 */   private org.apache.spark.unsafe.KVIterator agg_mapIter;
/* 027 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory;
/* 028 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize;
/* 029 */   private scala.collection.Iterator inputadapter_input;
/* 030 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 031 */   private UnsafeRow filter_result;
/* 032 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 033 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 034 */   private UnsafeRow project_result;
/* 035 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 036 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 037 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast;
/* 038 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation;
/* 039 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows;
/* 040 */   private UnsafeRow bhj_result;
/* 041 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder;
/* 042 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter;
/* 043 */   private UnsafeRow project_result1;
/* 044 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder1;
/* 045 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter1;
/* 046 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast1;
/* 047 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation1;
/* 048 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows1;
/* 049 */   private UnsafeRow bhj_result1;
/* 050 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder1;
/* 051 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter1;
/* 052 */   private UnsafeRow project_result2;
/* 053 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder2;
/* 054 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter2;
/* 055 */   private UnsafeRow agg_result8;
/* 056 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 057 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 058 */   private int agg_value28;
/* 059 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowJoiner agg_unsafeRowJoiner;
/* 060 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 061 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 062 */
/* 063 */   public GeneratedIterator(Object[] references) {
/* 064 */     this.references = references;
/* 065 */   }
/* 066 */
/* 067 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 068 */     partitionIndex = index;
/* 069 */     this.inputs = inputs;
/* 070 */     wholestagecodegen_init_0();
/* 071 */     wholestagecodegen_init_1();
/* 072 */     wholestagecodegen_init_2();
/* 073 */
/* 074 */   }
/* 075 */
/* 076 */   private void wholestagecodegen_init_0() {
/* 077 */     agg_initAgg = false;
/* 078 */
/* 079 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 080 */     agg_fastHashMap = new agg_FastHashMap(agg_plan.getTaskMemoryManager(), agg_plan.getEmptyAggregationBuffer());
/* 081 */
/* 082 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 083 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 084 */     inputadapter_input = inputs[0];
/* 085 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[17];
/* 086 */     filter_result = new UnsafeRow(20);
/* 087 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 288);
/* 088 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 20);
/* 089 */     project_result = new UnsafeRow(2);
/* 090 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 091 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 2);
/* 092 */
/* 093 */   }
/* 094 */
/* 095 */   public class agg_FastHashMap {
/* 096 */     private org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch batch;
/* 097 */     private int[] buckets;
/* 098 */     private int capacity = 1 << 16;
/* 099 */     private double loadFactor = 0.5;
/* 100 */     private int numBuckets = (int) (capacity / loadFactor);
/* 101 */     private int maxSteps = 2;
/* 102 */     private int numRows = 0;
/* 103 */     private org.apache.spark.sql.types.StructType keySchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[3])", org.apache.spark.sql.types.DataTypes.StringType)
/* 104 */     .add("((java.lang.String) references[4])", org.apache.spark.sql.types.DataTypes.StringType)
/* 105 */     .add("((java.lang.String) references[5])", org.apache.spark.sql.types.DataTypes.StringType)
/* 106 */     .add("((java.lang.String) references[6])", org.apache.spark.sql.types.DataTypes.IntegerType)
/* 107 */     .add("((java.lang.String) references[7])", org.apache.spark.sql.types.DataTypes.StringType)
/* 108 */     .add("((java.lang.String) references[8])", org.apache.spark.sql.types.DataTypes.IntegerType)
/* 109 */     .add("((java.lang.String) references[9])", org.apache.spark.sql.types.DataTypes.IntegerType)
/* 110 */     .add("((java.lang.String) references[10])", org.apache.spark.sql.types.DataTypes.IntegerType);
/* 111 */     private org.apache.spark.sql.types.StructType valueSchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[11])", org.apache.spark.sql.types.DataTypes.LongType)
/* 112 */     .add("((java.lang.String) references[12])", org.apache.spark.sql.types.DataTypes.LongType)
/* 113 */     .add("((java.lang.String) references[13])", org.apache.spark.sql.types.DataTypes.LongType)
/* 114 */     .add("((java.lang.String) references[14])", org.apache.spark.sql.types.DataTypes.LongType)
/* 115 */     .add("((java.lang.String) references[15])", org.apache.spark.sql.types.DataTypes.LongType)
/* 116 */     .add("((java.lang.String) references[16])", org.apache.spark.sql.types.DataTypes.LongType);
/* 117 */     private Object emptyVBase;
/* 118 */     private long emptyVOff;
/* 119 */     private int emptyVLen;
/* 120 */     private boolean isBatchFull = false;
/* 121 */
/* 122 */     public agg_FastHashMap(
/* 123 */       org.apache.spark.memory.TaskMemoryManager taskMemoryManager,
/* 124 */       InternalRow emptyAggregationBuffer) {
/* 125 */       batch = org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch
/* 126 */       .allocate(keySchema, valueSchema, taskMemoryManager, capacity);
/* 127 */
/* 128 */       final UnsafeProjection valueProjection = UnsafeProjection.create(valueSchema);
/* 129 */       final byte[] emptyBuffer = valueProjection.apply(emptyAggregationBuffer).getBytes();
/* 130 */
/* 131 */       emptyVBase = emptyBuffer;
/* 132 */       emptyVOff = Platform.BYTE_ARRAY_OFFSET;
/* 133 */       emptyVLen = emptyBuffer.length;
/* 134 */
/* 135 */       buckets = new int[numBuckets];
/* 136 */       java.util.Arrays.fill(buckets, -1);
/* 137 */     }
/* 138 */
/* 139 */     public org.apache.spark.sql.catalyst.expressions.UnsafeRow findOrInsert(UTF8String agg_key, UTF8String agg_key1, UTF8String agg_key2, int agg_key3, UTF8String agg_key4, int agg_key5, int agg_key6, int agg_key7) {
/* 140 */       long h = hash(agg_key, agg_key1, agg_key2, agg_key3, agg_key4, agg_key5, agg_key6, agg_key7);
/* 141 */       int step = 0;
/* 142 */       int idx = (int) h & (numBuckets - 1);
/* 143 */       while (step < maxSteps) {
/* 144 */         // Return bucket index if it's either an empty slot or already contains the key
/* 145 */         if (buckets[idx] == -1) {
/* 146 */           if (numRows < capacity && !isBatchFull) {
/* 147 */             // creating the unsafe for new entry
/* 148 */             UnsafeRow agg_result = new UnsafeRow(8);
/* 149 */             org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder
/* 150 */             = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result,
/* 151 */               128);
/* 152 */             org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter
/* 153 */             = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(
/* 154 */               agg_holder,
/* 155 */               8);
/* 156 */             agg_holder.reset(); //TODO: investigate if reset or zeroout are actually needed
/* 157 */             agg_rowWriter.zeroOutNullBytes();
/* 158 */             agg_rowWriter.write(0, agg_key);
/* 159 */             agg_rowWriter.write(1, agg_key1);
/* 160 */             agg_rowWriter.write(2, agg_key2);
/* 161 */             agg_rowWriter.write(3, agg_key3);
/* 162 */             agg_rowWriter.write(4, agg_key4);
/* 163 */             agg_rowWriter.write(5, agg_key5);
/* 164 */             agg_rowWriter.write(6, agg_key6);
/* 165 */             agg_rowWriter.write(7, agg_key7);
/* 166 */             agg_result.setTotalSize(agg_holder.totalSize());
/* 167 */             Object kbase = agg_result.getBaseObject();
/* 168 */             long koff = agg_result.getBaseOffset();
/* 169 */             int klen = agg_result.getSizeInBytes();
/* 170 */
/* 171 */             UnsafeRow vRow
/* 172 */             = batch.appendRow(kbase, koff, klen, emptyVBase, emptyVOff, emptyVLen);
/* 173 */             if (vRow == null) {
/* 174 */               isBatchFull = true;
/* 175 */             } else {
/* 176 */               buckets[idx] = numRows++;
/* 177 */             }
/* 178 */             return vRow;
/* 179 */           } else {
/* 180 */             // No more space
/* 181 */             return null;
/* 182 */           }
/* 183 */         } else if (equals(idx, agg_key, agg_key1, agg_key2, agg_key3, agg_key4, agg_key5, agg_key6, agg_key7)) {
/* 184 */           return batch.getValueRow(buckets[idx]);
/* 185 */         }
/* 186 */         idx = (idx + 1) & (numBuckets - 1);
/* 187 */         step++;
/* 188 */       }
/* 189 */       // Didn't find it
/* 190 */       return null;
/* 191 */     }
/* 192 */
/* 193 */     private boolean equals(int idx, UTF8String agg_key, UTF8String agg_key1, UTF8String agg_key2, int agg_key3, UTF8String agg_key4, int agg_key5, int agg_key6, int agg_key7) {
/* 194 */       UnsafeRow row = batch.getKeyRow(buckets[idx]);
/* 195 */       return (row.getUTF8String(0).equals(agg_key)) && (row.getUTF8String(1).equals(agg_key1)) && (row.getUTF8String(2).equals(agg_key2)) && (row.getInt(3) == agg_key3) && (row.getUTF8String(4).equals(agg_key4)) && (row.getInt(5) == agg_key5) && (row.getInt(6) == agg_key6) && (row.getInt(7) == agg_key7);
/* 196 */     }
/* 197 */
/* 198 */     private long hash(UTF8String agg_key, UTF8String agg_key1, UTF8String agg_key2, int agg_key3, UTF8String agg_key4, int agg_key5, int agg_key6, int agg_key7) {
/* 199 */       long agg_hash = 0;
/* 200 */
/* 201 */       int agg_result = 0;
/* 202 */       byte[] agg_bytes = agg_key.getBytes();
/* 203 */       for (int i = 0; i < agg_bytes.length; i++) {
/* 204 */         int agg_hash1 = agg_bytes[i];
/* 205 */         agg_result = (agg_result ^ (0x9e3779b9)) + agg_hash1 + (agg_result << 6) + (agg_result >>> 2);
/* 206 */       }
/* 207 */
/* 208 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result + (agg_hash << 6) + (agg_hash >>> 2);
/* 209 */
/* 210 */       int agg_result1 = 0;
/* 211 */       byte[] agg_bytes1 = agg_key1.getBytes();
/* 212 */       for (int i = 0; i < agg_bytes1.length; i++) {
/* 213 */         int agg_hash2 = agg_bytes1[i];
/* 214 */         agg_result1 = (agg_result1 ^ (0x9e3779b9)) + agg_hash2 + (agg_result1 << 6) + (agg_result1 >>> 2);
/* 215 */       }
/* 216 */
/* 217 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result1 + (agg_hash << 6) + (agg_hash >>> 2);
/* 218 */
/* 219 */       int agg_result2 = 0;
/* 220 */       byte[] agg_bytes2 = agg_key2.getBytes();
/* 221 */       for (int i = 0; i < agg_bytes2.length; i++) {
/* 222 */         int agg_hash3 = agg_bytes2[i];
/* 223 */         agg_result2 = (agg_result2 ^ (0x9e3779b9)) + agg_hash3 + (agg_result2 << 6) + (agg_result2 >>> 2);
/* 224 */       }
/* 225 */
/* 226 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result2 + (agg_hash << 6) + (agg_hash >>> 2);
/* 227 */
/* 228 */       int agg_result3 = agg_key3;
/* 229 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result3 + (agg_hash << 6) + (agg_hash >>> 2);
/* 230 */
/* 231 */       int agg_result4 = 0;
/* 232 */       byte[] agg_bytes3 = agg_key4.getBytes();
/* 233 */       for (int i = 0; i < agg_bytes3.length; i++) {
/* 234 */         int agg_hash4 = agg_bytes3[i];
/* 235 */         agg_result4 = (agg_result4 ^ (0x9e3779b9)) + agg_hash4 + (agg_result4 << 6) + (agg_result4 >>> 2);
/* 236 */       }
/* 237 */
/* 238 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result4 + (agg_hash << 6) + (agg_hash >>> 2);
/* 239 */
/* 240 */       int agg_result5 = agg_key5;
/* 241 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result5 + (agg_hash << 6) + (agg_hash >>> 2);
/* 242 */
/* 243 */       int agg_result6 = agg_key6;
/* 244 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result6 + (agg_hash << 6) + (agg_hash >>> 2);
/* 245 */
/* 246 */       int agg_result7 = agg_key7;
/* 247 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result7 + (agg_hash << 6) + (agg_hash >>> 2);
/* 248 */
/* 249 */       return agg_hash;
/* 250 */     }
/* 251 */
/* 252 */     public org.apache.spark.unsafe.KVIterator<UnsafeRow, UnsafeRow> rowIterator() {
/* 253 */       return batch.rowIterator();
/* 254 */     }
/* 255 */
/* 256 */     public void close() {
/* 257 */       batch.close();
/* 258 */     }
/* 259 */
/* 260 */   }
/* 261 */
/* 262 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 263 */     agg_hashMap = agg_plan.createHashMap();
/* 264 */
/* 265 */     while (inputadapter_input.hasNext() && !stopEarly()) {
/* 266 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 267 */       boolean inputadapter_value18 = inputadapter_row.getBoolean(18);
/* 268 */       boolean inputadapter_value19 = inputadapter_row.getBoolean(19);
/* 269 */
/* 270 */       boolean filter_value = true;
/* 271 */
/* 272 */       if (!inputadapter_value18) {
/* 273 */         filter_value = inputadapter_value19;
/* 274 */       }
/* 275 */       if (!filter_value) continue;
/* 276 */
/* 277 */       filter_numOutputRows.add(1);
/* 278 */
/* 279 */       boolean inputadapter_isNull4 = inputadapter_row.isNullAt(4);
/* 280 */       int inputadapter_value4 = inputadapter_isNull4 ? -1 : (inputadapter_row.getInt(4));
/* 281 */
/* 282 */       // generate join key for stream side
/* 283 */
/* 284 */       boolean bhj_isNull = inputadapter_isNull4;
/* 285 */       long bhj_value = -1L;
/* 286 */       if (!inputadapter_isNull4) {
/* 287 */         bhj_value = (long) inputadapter_value4;
/* 288 */       }
/* 289 */       // find matches from HashedRelation
/* 290 */       UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 291 */       if (bhj_matched == null) continue;
/* 292 */
/* 293 */       bhj_numOutputRows.add(1);
/* 294 */
/* 295 */       boolean inputadapter_isNull2 = inputadapter_row.isNullAt(2);
/* 296 */       int inputadapter_value2 = inputadapter_isNull2 ? -1 : (inputadapter_row.getInt(2));
/* 297 */
/* 298 */       // generate join key for stream side
/* 299 */
/* 300 */       boolean bhj_isNull6 = inputadapter_isNull2;
/* 301 */       long bhj_value6 = -1L;
/* 302 */       if (!inputadapter_isNull2) {
/* 303 */         bhj_value6 = (long) inputadapter_value2;
/* 304 */       }
/* 305 */       // find matches from HashedRelation
/* 306 */       UnsafeRow bhj_matched1 = bhj_isNull6 ? null: (UnsafeRow)bhj_relation1.getValue(bhj_value6);
/* 307 */       if (bhj_matched1 == null) continue;
/* 308 */
/* 309 */       bhj_numOutputRows1.add(1);
/* 310 */
/* 311 */       boolean bhj_isNull9 = bhj_matched1.isNullAt(1);
/* 312 */       UTF8String bhj_value9 = bhj_isNull9 ? null : (bhj_matched1.getUTF8String(1));
/* 313 */       boolean bhj_isNull10 = bhj_matched1.isNullAt(2);
/* 314 */       UTF8String bhj_value10 = bhj_isNull10 ? null : (bhj_matched1.getUTF8String(2));
/* 315 */       boolean bhj_isNull11 = bhj_matched1.isNullAt(3);
/* 316 */       UTF8String bhj_value11 = bhj_isNull11 ? null : (bhj_matched1.getUTF8String(3));
/* 317 */       boolean bhj_isNull12 = bhj_matched1.isNullAt(4);
/* 318 */       int bhj_value12 = bhj_isNull12 ? -1 : (bhj_matched1.getInt(4));
/* 319 */       boolean bhj_isNull13 = bhj_matched1.isNullAt(5);
/* 320 */       UTF8String bhj_value13 = bhj_isNull13 ? null : (bhj_matched1.getUTF8String(5));
/* 321 */       boolean bhj_isNull14 = bhj_matched1.isNullAt(6);
/* 322 */       int bhj_value14 = bhj_isNull14 ? -1 : (bhj_matched1.getInt(6));
/* 323 */       boolean bhj_isNull15 = bhj_matched1.isNullAt(7);
/* 324 */       int bhj_value15 = bhj_isNull15 ? -1 : (bhj_matched1.getInt(7));
/* 325 */       boolean bhj_isNull16 = bhj_matched1.isNullAt(8);
/* 326 */       int bhj_value16 = bhj_isNull16 ? -1 : (bhj_matched1.getInt(8));
/* 327 */
/* 328 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 329 */
/* 330 */       UnsafeRow agg_fastAggBuffer = null;
/* 331 */
/* 332 */       if (true) {
/* 333 */         if (!bhj_isNull9 && !bhj_isNull10 && !bhj_isNull11 && !bhj_isNull12 && !bhj_isNull13 && !bhj_isNull14 && !bhj_isNull15 && !bhj_isNull16) {
/* 334 */           agg_fastAggBuffer = agg_fastHashMap.findOrInsert(
/* 335 */             bhj_value9, bhj_value10, bhj_value11, bhj_value12, bhj_value13, bhj_value14, bhj_value15, bhj_value16);
/* 336 */         }
/* 337 */       }
/* 338 */
/* 339 */       if (agg_fastAggBuffer == null) {
/* 340 */         // generate grouping key
/* 341 */         agg_holder.reset();
/* 342 */
/* 343 */         agg_rowWriter.zeroOutNullBytes();
/* 344 */
/* 345 */         if (bhj_isNull9) {
/* 346 */           agg_rowWriter.setNullAt(0);
/* 347 */         } else {
/* 348 */           agg_rowWriter.write(0, bhj_value9);
/* 349 */         }
/* 350 */
/* 351 */         if (bhj_isNull10) {
/* 352 */           agg_rowWriter.setNullAt(1);
/* 353 */         } else {
/* 354 */           agg_rowWriter.write(1, bhj_value10);
/* 355 */         }
/* 356 */
/* 357 */         if (bhj_isNull11) {
/* 358 */           agg_rowWriter.setNullAt(2);
/* 359 */         } else {
/* 360 */           agg_rowWriter.write(2, bhj_value11);
/* 361 */         }
/* 362 */
/* 363 */         if (bhj_isNull12) {
/* 364 */           agg_rowWriter.setNullAt(3);
/* 365 */         } else {
/* 366 */           agg_rowWriter.write(3, bhj_value12);
/* 367 */         }
/* 368 */
/* 369 */         if (bhj_isNull13) {
/* 370 */           agg_rowWriter.setNullAt(4);
/* 371 */         } else {
/* 372 */           agg_rowWriter.write(4, bhj_value13);
/* 373 */         }
/* 374 */
/* 375 */         if (bhj_isNull14) {
/* 376 */           agg_rowWriter.setNullAt(5);
/* 377 */         } else {
/* 378 */           agg_rowWriter.write(5, bhj_value14);
/* 379 */         }
/* 380 */
/* 381 */         if (bhj_isNull15) {
/* 382 */           agg_rowWriter.setNullAt(6);
/* 383 */         } else {
/* 384 */           agg_rowWriter.write(6, bhj_value15);
/* 385 */         }
/* 386 */
/* 387 */         if (bhj_isNull16) {
/* 388 */           agg_rowWriter.setNullAt(7);
/* 389 */         } else {
/* 390 */           agg_rowWriter.write(7, bhj_value16);
/* 391 */         }
/* 392 */         agg_result8.setTotalSize(agg_holder.totalSize());
/* 393 */         agg_value28 = 42;
/* 394 */
/* 395 */         if (!bhj_isNull9) {
/* 396 */           agg_value28 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value9.getBaseObject(), bhj_value9.getBaseOffset(), bhj_value9.numBytes(), agg_value28);
/* 397 */         }
/* 398 */
/* 399 */         if (!bhj_isNull10) {
/* 400 */           agg_value28 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value10.getBaseObject(), bhj_value10.getBaseOffset(), bhj_value10.numBytes(), agg_value28);
/* 401 */         }
/* 402 */
/* 403 */         if (!bhj_isNull11) {
/* 404 */           agg_value28 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value11.getBaseObject(), bhj_value11.getBaseOffset(), bhj_value11.numBytes(), agg_value28);
/* 405 */         }
/* 406 */
/* 407 */         if (!bhj_isNull12) {
/* 408 */           agg_value28 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(bhj_value12, agg_value28);
/* 409 */         }
/* 410 */
/* 411 */         if (!bhj_isNull13) {
/* 412 */           agg_value28 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value13.getBaseObject(), bhj_value13.getBaseOffset(), bhj_value13.numBytes(), agg_value28);
/* 413 */         }
/* 414 */
/* 415 */         if (!bhj_isNull14) {
/* 416 */           agg_value28 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(bhj_value14, agg_value28);
/* 417 */         }
/* 418 */
/* 419 */         if (!bhj_isNull15) {
/* 420 */           agg_value28 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(bhj_value15, agg_value28);
/* 421 */         }
/* 422 */
/* 423 */         if (!bhj_isNull16) {
/* 424 */           agg_value28 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(bhj_value16, agg_value28);
/* 425 */         }
/* 426 */         if (true) {
/* 427 */           // try to get the buffer from hash map
/* 428 */           agg_unsafeRowAggBuffer =
/* 429 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result8, agg_value28);
/* 430 */         }
/* 431 */         if (agg_unsafeRowAggBuffer == null) {
/* 432 */           if (agg_sorter == null) {
/* 433 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 434 */           } else {
/* 435 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 436 */           }
/* 437 */
/* 438 */           // the hash map had be spilled, it should have enough memory now,
/* 439 */           // try  to allocate buffer again.
/* 440 */           agg_unsafeRowAggBuffer =
/* 441 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result8, agg_value28);
/* 442 */           if (agg_unsafeRowAggBuffer == null) {
/* 443 */             // failed to allocate the first page
/* 444 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 445 */           }
/* 446 */         }
/* 447 */       }
/* 448 */
/* 449 */       if (agg_fastAggBuffer != null) {
/* 450 */         // update fast row
/* 451 */
/* 452 */         // common sub-expressions
/* 453 */
/* 454 */         // evaluate aggregate function
/* 455 */         boolean agg_isNull49 = false;
/* 456 */
/* 457 */         long agg_value56 = agg_fastAggBuffer.getLong(0);
/* 458 */
/* 459 */         long agg_value55 = -1L;
/* 460 */         agg_value55 = agg_value56 + 1L;
/* 461 */         boolean agg_isNull52 = false;
/* 462 */
/* 463 */         long agg_value59 = agg_fastAggBuffer.getLong(1);
/* 464 */
/* 465 */         long agg_value58 = -1L;
/* 466 */         agg_value58 = agg_value59 + 1L;
/* 467 */         boolean agg_isNull55 = false;
/* 468 */
/* 469 */         long agg_value62 = agg_fastAggBuffer.getLong(2);
/* 470 */
/* 471 */         long agg_value61 = -1L;
/* 472 */         agg_value61 = agg_value62 + 1L;
/* 473 */         boolean agg_isNull58 = false;
/* 474 */
/* 475 */         long agg_value65 = agg_fastAggBuffer.getLong(3);
/* 476 */
/* 477 */         long agg_value64 = -1L;
/* 478 */         agg_value64 = agg_value65 + 1L;
/* 479 */         boolean agg_isNull61 = false;
/* 480 */
/* 481 */         long agg_value68 = agg_fastAggBuffer.getLong(4);
/* 482 */
/* 483 */         long agg_value67 = -1L;
/* 484 */         agg_value67 = agg_value68 + 1L;
/* 485 */         boolean agg_isNull64 = false;
/* 486 */
/* 487 */         long agg_value71 = agg_fastAggBuffer.getLong(5);
/* 488 */
/* 489 */         long agg_value70 = -1L;
/* 490 */         agg_value70 = agg_value71 + 1L;
/* 491 */         // update fast row
/* 492 */         agg_fastAggBuffer.setLong(0, agg_value55);
/* 493 */         agg_fastAggBuffer.setLong(1, agg_value58);
/* 494 */         agg_fastAggBuffer.setLong(2, agg_value61);
/* 495 */         agg_fastAggBuffer.setLong(3, agg_value64);
/* 496 */         agg_fastAggBuffer.setLong(4, agg_value67);
/* 497 */         agg_fastAggBuffer.setLong(5, agg_value70);
/* 498 */
/* 499 */       } else {
/* 500 */         // update unsafe row
/* 501 */
/* 502 */         // common sub-expressions
/* 503 */
/* 504 */         // evaluate aggregate function
/* 505 */         boolean agg_isNull31 = false;
/* 506 */
/* 507 */         long agg_value38 = agg_unsafeRowAggBuffer.getLong(0);
/* 508 */
/* 509 */         long agg_value37 = -1L;
/* 510 */         agg_value37 = agg_value38 + 1L;
/* 511 */         boolean agg_isNull34 = false;
/* 512 */
/* 513 */         long agg_value41 = agg_unsafeRowAggBuffer.getLong(1);
/* 514 */
/* 515 */         long agg_value40 = -1L;
/* 516 */         agg_value40 = agg_value41 + 1L;
/* 517 */         boolean agg_isNull37 = false;
/* 518 */
/* 519 */         long agg_value44 = agg_unsafeRowAggBuffer.getLong(2);
/* 520 */
/* 521 */         long agg_value43 = -1L;
/* 522 */         agg_value43 = agg_value44 + 1L;
/* 523 */         boolean agg_isNull40 = false;
/* 524 */
/* 525 */         long agg_value47 = agg_unsafeRowAggBuffer.getLong(3);
/* 526 */
/* 527 */         long agg_value46 = -1L;
/* 528 */         agg_value46 = agg_value47 + 1L;
/* 529 */         boolean agg_isNull43 = false;
/* 530 */
/* 531 */         long agg_value50 = agg_unsafeRowAggBuffer.getLong(4);
/* 532 */
/* 533 */         long agg_value49 = -1L;
/* 534 */         agg_value49 = agg_value50 + 1L;
/* 535 */         boolean agg_isNull46 = false;
/* 536 */
/* 537 */         long agg_value53 = agg_unsafeRowAggBuffer.getLong(5);
/* 538 */
/* 539 */         long agg_value52 = -1L;
/* 540 */         agg_value52 = agg_value53 + 1L;
/* 541 */         // update unsafe row buffer
/* 542 */         agg_unsafeRowAggBuffer.setLong(0, agg_value37);
/* 543 */         agg_unsafeRowAggBuffer.setLong(1, agg_value40);
/* 544 */         agg_unsafeRowAggBuffer.setLong(2, agg_value43);
/* 545 */         agg_unsafeRowAggBuffer.setLong(3, agg_value46);
/* 546 */         agg_unsafeRowAggBuffer.setLong(4, agg_value49);
/* 547 */         agg_unsafeRowAggBuffer.setLong(5, agg_value52);
/* 548 */
/* 549 */       }
/* 550 */       if (shouldStop()) return;
/* 551 */     }
/* 552 */
/* 553 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 554 */
/* 555 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 556 */   }
/* 557 */
/* 558 */   private void wholestagecodegen_init_2() {
/* 559 */     this.bhj_numOutputRows1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[21];
/* 560 */     bhj_result1 = new UnsafeRow(10);
/* 561 */     this.bhj_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result1, 128);
/* 562 */     this.bhj_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder1, 10);
/* 563 */     project_result2 = new UnsafeRow(8);
/* 564 */     this.project_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result2, 128);
/* 565 */     this.project_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder2, 8);
/* 566 */     agg_result8 = new UnsafeRow(8);
/* 567 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result8, 128);
/* 568 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 8);
/* 569 */
/* 570 */     agg_unsafeRowJoiner = agg_plan.createUnsafeJoiner();
/* 571 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[22];
/* 572 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[23];
/* 573 */
/* 574 */   }
/* 575 */
/* 576 */   private void wholestagecodegen_init_1() {
/* 577 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[18];
/* 578 */
/* 579 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 580 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 581 */
/* 582 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[19];
/* 583 */     bhj_result = new UnsafeRow(3);
/* 584 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 0);
/* 585 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 3);
/* 586 */     project_result1 = new UnsafeRow(1);
/* 587 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 0);
/* 588 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 1);
/* 589 */     this.bhj_broadcast1 = (org.apache.spark.broadcast.TorrentBroadcast) references[20];
/* 590 */
/* 591 */     bhj_relation1 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast1.value()).asReadOnlyCopy();
/* 592 */     incPeakExecutionMemory(bhj_relation1.estimatedSize());
/* 593 */
/* 594 */   }
/* 595 */
/* 596 */   protected void processNext() throws java.io.IOException {
/* 597 */     if (!agg_initAgg) {
/* 598 */       agg_initAgg = true;
/* 599 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 600 */       agg_doAggregateWithKeys();
/* 601 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 602 */     }
/* 603 */
/* 604 */     // output the result
/* 605 */
/* 606 */     while (agg_fastHashMapIter.next()) {
/* 607 */       wholestagecodegen_numOutputRows.add(1);
/* 608 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 609 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 610 */
/* 611 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 612 */
/* 613 */       append(agg_resultRow);
/* 614 */
/* 615 */       if (shouldStop()) return;
/* 616 */     }
/* 617 */     agg_fastHashMap.close();
/* 618 */
/* 619 */     while (agg_mapIter.next()) {
/* 620 */       wholestagecodegen_numOutputRows.add(1);
/* 621 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 622 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 623 */
/* 624 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 625 */
/* 626 */       append(agg_resultRow);
/* 627 */
/* 628 */       if (shouldStop()) return;
/* 629 */     }
/* 630 */
/* 631 */     agg_mapIter.close();
/* 632 */     if (agg_sorter == null) {
/* 633 */       agg_hashMap.free();
/* 634 */     }
/* 635 */   }
/* 636 */ }
