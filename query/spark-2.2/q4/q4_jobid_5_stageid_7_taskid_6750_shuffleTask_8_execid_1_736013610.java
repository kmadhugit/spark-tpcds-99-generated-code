/* 001 */ public Object generate(Object[] references) {
/* 002 */   return new GeneratedIterator(references);
/* 003 */ }
/* 004 */
/* 005 */ final class GeneratedIterator extends org.apache.spark.sql.execution.BufferedRowIterator {
/* 006 */   private Object[] references;
/* 007 */   private scala.collection.Iterator[] inputs;
/* 008 */   private boolean agg_initAgg;
/* 009 */   private boolean agg_bufIsNull;
/* 010 */   private double agg_bufValue;
/* 011 */   private org.apache.spark.sql.execution.aggregate.HashAggregateExec agg_plan;
/* 012 */   private agg_FastHashMap agg_fastHashMap;
/* 013 */   private org.apache.spark.unsafe.KVIterator agg_fastHashMapIter;
/* 014 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap;
/* 015 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter;
/* 016 */   private org.apache.spark.unsafe.KVIterator agg_mapIter;
/* 017 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory;
/* 018 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize;
/* 019 */   private scala.collection.Iterator smj_leftInput;
/* 020 */   private scala.collection.Iterator smj_rightInput;
/* 021 */   private InternalRow smj_leftRow;
/* 022 */   private InternalRow smj_rightRow;
/* 023 */   private int smj_value2;
/* 024 */   private org.apache.spark.sql.execution.ExternalAppendOnlyUnsafeRowArray smj_matches;
/* 025 */   private int smj_value3;
/* 026 */   private int smj_value4;
/* 027 */   private boolean smj_isNull2;
/* 028 */   private UTF8String smj_value5;
/* 029 */   private boolean smj_isNull3;
/* 030 */   private UTF8String smj_value6;
/* 031 */   private boolean smj_isNull4;
/* 032 */   private UTF8String smj_value7;
/* 033 */   private boolean smj_isNull5;
/* 034 */   private UTF8String smj_value8;
/* 035 */   private boolean smj_isNull6;
/* 036 */   private UTF8String smj_value9;
/* 037 */   private boolean smj_isNull7;
/* 038 */   private UTF8String smj_value10;
/* 039 */   private boolean smj_isNull8;
/* 040 */   private UTF8String smj_value11;
/* 041 */   private boolean smj_isNull9;
/* 042 */   private org.apache.spark.sql.execution.metric.SQLMetric smj_numOutputRows;
/* 043 */   private UnsafeRow smj_result;
/* 044 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder smj_holder;
/* 045 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter smj_rowWriter;
/* 046 */   private UnsafeRow project_result;
/* 047 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 048 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 049 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast;
/* 050 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation;
/* 051 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows;
/* 052 */   private UnsafeRow bhj_result;
/* 053 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder;
/* 054 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter;
/* 055 */   private UnsafeRow project_result1;
/* 056 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder1;
/* 057 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter1;
/* 058 */   private UnsafeRow agg_result8;
/* 059 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 060 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 061 */   private int agg_value18;
/* 062 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowJoiner agg_unsafeRowJoiner;
/* 063 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 064 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 065 */
/* 066 */   public GeneratedIterator(Object[] references) {
/* 067 */     this.references = references;
/* 068 */   }
/* 069 */
/* 070 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 071 */     partitionIndex = index;
/* 072 */     this.inputs = inputs;
/* 073 */     wholestagecodegen_init_0();
/* 074 */     wholestagecodegen_init_1();
/* 075 */     wholestagecodegen_init_2();
/* 076 */
/* 077 */   }
/* 078 */
/* 079 */   private void wholestagecodegen_init_0() {
/* 080 */     agg_initAgg = false;
/* 081 */
/* 082 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 083 */     agg_fastHashMap = new agg_FastHashMap(agg_plan.getTaskMemoryManager(), agg_plan.getEmptyAggregationBuffer());
/* 084 */
/* 085 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 086 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 087 */     smj_leftInput = inputs[0];
/* 088 */     smj_rightInput = inputs[1];
/* 089 */
/* 090 */     smj_rightRow = null;
/* 091 */
/* 092 */     smj_matches = new org.apache.spark.sql.execution.ExternalAppendOnlyUnsafeRowArray(2147483647);
/* 093 */
/* 094 */     this.smj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[12];
/* 095 */     smj_result = new UnsafeRow(14);
/* 096 */     this.smj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(smj_result, 224);
/* 097 */     this.smj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(smj_holder, 14);
/* 098 */     project_result = new UnsafeRow(12);
/* 099 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 224);
/* 100 */
/* 101 */   }
/* 102 */
/* 103 */   public class agg_FastHashMap {
/* 104 */     private org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch batch;
/* 105 */     private int[] buckets;
/* 106 */     private int capacity = 1 << 16;
/* 107 */     private double loadFactor = 0.5;
/* 108 */     private int numBuckets = (int) (capacity / loadFactor);
/* 109 */     private int maxSteps = 2;
/* 110 */     private int numRows = 0;
/* 111 */     private org.apache.spark.sql.types.StructType keySchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[3])", org.apache.spark.sql.types.DataTypes.StringType)
/* 112 */     .add("((java.lang.String) references[4])", org.apache.spark.sql.types.DataTypes.StringType)
/* 113 */     .add("((java.lang.String) references[5])", org.apache.spark.sql.types.DataTypes.StringType)
/* 114 */     .add("((java.lang.String) references[6])", org.apache.spark.sql.types.DataTypes.StringType)
/* 115 */     .add("((java.lang.String) references[7])", org.apache.spark.sql.types.DataTypes.StringType)
/* 116 */     .add("((java.lang.String) references[8])", org.apache.spark.sql.types.DataTypes.StringType)
/* 117 */     .add("((java.lang.String) references[9])", org.apache.spark.sql.types.DataTypes.StringType)
/* 118 */     .add("((java.lang.String) references[10])", org.apache.spark.sql.types.DataTypes.IntegerType);
/* 119 */     private org.apache.spark.sql.types.StructType valueSchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[11])", org.apache.spark.sql.types.DataTypes.DoubleType);
/* 120 */     private Object emptyVBase;
/* 121 */     private long emptyVOff;
/* 122 */     private int emptyVLen;
/* 123 */     private boolean isBatchFull = false;
/* 124 */
/* 125 */     public agg_FastHashMap(
/* 126 */       org.apache.spark.memory.TaskMemoryManager taskMemoryManager,
/* 127 */       InternalRow emptyAggregationBuffer) {
/* 128 */       batch = org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch
/* 129 */       .allocate(keySchema, valueSchema, taskMemoryManager, capacity);
/* 130 */
/* 131 */       final UnsafeProjection valueProjection = UnsafeProjection.create(valueSchema);
/* 132 */       final byte[] emptyBuffer = valueProjection.apply(emptyAggregationBuffer).getBytes();
/* 133 */
/* 134 */       emptyVBase = emptyBuffer;
/* 135 */       emptyVOff = Platform.BYTE_ARRAY_OFFSET;
/* 136 */       emptyVLen = emptyBuffer.length;
/* 137 */
/* 138 */       buckets = new int[numBuckets];
/* 139 */       java.util.Arrays.fill(buckets, -1);
/* 140 */     }
/* 141 */
/* 142 */     public org.apache.spark.sql.catalyst.expressions.UnsafeRow findOrInsert(UTF8String agg_key, UTF8String agg_key1, UTF8String agg_key2, UTF8String agg_key3, UTF8String agg_key4, UTF8String agg_key5, UTF8String agg_key6, int agg_key7) {
/* 143 */       long h = hash(agg_key, agg_key1, agg_key2, agg_key3, agg_key4, agg_key5, agg_key6, agg_key7);
/* 144 */       int step = 0;
/* 145 */       int idx = (int) h & (numBuckets - 1);
/* 146 */       while (step < maxSteps) {
/* 147 */         // Return bucket index if it's either an empty slot or already contains the key
/* 148 */         if (buckets[idx] == -1) {
/* 149 */           if (numRows < capacity && !isBatchFull) {
/* 150 */             // creating the unsafe for new entry
/* 151 */             UnsafeRow agg_result = new UnsafeRow(8);
/* 152 */             org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder
/* 153 */             = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result,
/* 154 */               224);
/* 155 */             org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter
/* 156 */             = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(
/* 157 */               agg_holder,
/* 158 */               8);
/* 159 */             agg_holder.reset(); //TODO: investigate if reset or zeroout are actually needed
/* 160 */             agg_rowWriter.zeroOutNullBytes();
/* 161 */             agg_rowWriter.write(0, agg_key);
/* 162 */             agg_rowWriter.write(1, agg_key1);
/* 163 */             agg_rowWriter.write(2, agg_key2);
/* 164 */             agg_rowWriter.write(3, agg_key3);
/* 165 */             agg_rowWriter.write(4, agg_key4);
/* 166 */             agg_rowWriter.write(5, agg_key5);
/* 167 */             agg_rowWriter.write(6, agg_key6);
/* 168 */             agg_rowWriter.write(7, agg_key7);
/* 169 */             agg_result.setTotalSize(agg_holder.totalSize());
/* 170 */             Object kbase = agg_result.getBaseObject();
/* 171 */             long koff = agg_result.getBaseOffset();
/* 172 */             int klen = agg_result.getSizeInBytes();
/* 173 */
/* 174 */             UnsafeRow vRow
/* 175 */             = batch.appendRow(kbase, koff, klen, emptyVBase, emptyVOff, emptyVLen);
/* 176 */             if (vRow == null) {
/* 177 */               isBatchFull = true;
/* 178 */             } else {
/* 179 */               buckets[idx] = numRows++;
/* 180 */             }
/* 181 */             return vRow;
/* 182 */           } else {
/* 183 */             // No more space
/* 184 */             return null;
/* 185 */           }
/* 186 */         } else if (equals(idx, agg_key, agg_key1, agg_key2, agg_key3, agg_key4, agg_key5, agg_key6, agg_key7)) {
/* 187 */           return batch.getValueRow(buckets[idx]);
/* 188 */         }
/* 189 */         idx = (idx + 1) & (numBuckets - 1);
/* 190 */         step++;
/* 191 */       }
/* 192 */       // Didn't find it
/* 193 */       return null;
/* 194 */     }
/* 195 */
/* 196 */     private boolean equals(int idx, UTF8String agg_key, UTF8String agg_key1, UTF8String agg_key2, UTF8String agg_key3, UTF8String agg_key4, UTF8String agg_key5, UTF8String agg_key6, int agg_key7) {
/* 197 */       UnsafeRow row = batch.getKeyRow(buckets[idx]);
/* 198 */       return (row.getUTF8String(0).equals(agg_key)) && (row.getUTF8String(1).equals(agg_key1)) && (row.getUTF8String(2).equals(agg_key2)) && (row.getUTF8String(3).equals(agg_key3)) && (row.getUTF8String(4).equals(agg_key4)) && (row.getUTF8String(5).equals(agg_key5)) && (row.getUTF8String(6).equals(agg_key6)) && (row.getInt(7) == agg_key7);
/* 199 */     }
/* 200 */
/* 201 */     private long hash(UTF8String agg_key, UTF8String agg_key1, UTF8String agg_key2, UTF8String agg_key3, UTF8String agg_key4, UTF8String agg_key5, UTF8String agg_key6, int agg_key7) {
/* 202 */       long agg_hash = 0;
/* 203 */
/* 204 */       int agg_result = 0;
/* 205 */       byte[] agg_bytes = agg_key.getBytes();
/* 206 */       for (int i = 0; i < agg_bytes.length; i++) {
/* 207 */         int agg_hash1 = agg_bytes[i];
/* 208 */         agg_result = (agg_result ^ (0x9e3779b9)) + agg_hash1 + (agg_result << 6) + (agg_result >>> 2);
/* 209 */       }
/* 210 */
/* 211 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result + (agg_hash << 6) + (agg_hash >>> 2);
/* 212 */
/* 213 */       int agg_result1 = 0;
/* 214 */       byte[] agg_bytes1 = agg_key1.getBytes();
/* 215 */       for (int i = 0; i < agg_bytes1.length; i++) {
/* 216 */         int agg_hash2 = agg_bytes1[i];
/* 217 */         agg_result1 = (agg_result1 ^ (0x9e3779b9)) + agg_hash2 + (agg_result1 << 6) + (agg_result1 >>> 2);
/* 218 */       }
/* 219 */
/* 220 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result1 + (agg_hash << 6) + (agg_hash >>> 2);
/* 221 */
/* 222 */       int agg_result2 = 0;
/* 223 */       byte[] agg_bytes2 = agg_key2.getBytes();
/* 224 */       for (int i = 0; i < agg_bytes2.length; i++) {
/* 225 */         int agg_hash3 = agg_bytes2[i];
/* 226 */         agg_result2 = (agg_result2 ^ (0x9e3779b9)) + agg_hash3 + (agg_result2 << 6) + (agg_result2 >>> 2);
/* 227 */       }
/* 228 */
/* 229 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result2 + (agg_hash << 6) + (agg_hash >>> 2);
/* 230 */
/* 231 */       int agg_result3 = 0;
/* 232 */       byte[] agg_bytes3 = agg_key3.getBytes();
/* 233 */       for (int i = 0; i < agg_bytes3.length; i++) {
/* 234 */         int agg_hash4 = agg_bytes3[i];
/* 235 */         agg_result3 = (agg_result3 ^ (0x9e3779b9)) + agg_hash4 + (agg_result3 << 6) + (agg_result3 >>> 2);
/* 236 */       }
/* 237 */
/* 238 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result3 + (agg_hash << 6) + (agg_hash >>> 2);
/* 239 */
/* 240 */       int agg_result4 = 0;
/* 241 */       byte[] agg_bytes4 = agg_key4.getBytes();
/* 242 */       for (int i = 0; i < agg_bytes4.length; i++) {
/* 243 */         int agg_hash5 = agg_bytes4[i];
/* 244 */         agg_result4 = (agg_result4 ^ (0x9e3779b9)) + agg_hash5 + (agg_result4 << 6) + (agg_result4 >>> 2);
/* 245 */       }
/* 246 */
/* 247 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result4 + (agg_hash << 6) + (agg_hash >>> 2);
/* 248 */
/* 249 */       int agg_result5 = 0;
/* 250 */       byte[] agg_bytes5 = agg_key5.getBytes();
/* 251 */       for (int i = 0; i < agg_bytes5.length; i++) {
/* 252 */         int agg_hash6 = agg_bytes5[i];
/* 253 */         agg_result5 = (agg_result5 ^ (0x9e3779b9)) + agg_hash6 + (agg_result5 << 6) + (agg_result5 >>> 2);
/* 254 */       }
/* 255 */
/* 256 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result5 + (agg_hash << 6) + (agg_hash >>> 2);
/* 257 */
/* 258 */       int agg_result6 = 0;
/* 259 */       byte[] agg_bytes6 = agg_key6.getBytes();
/* 260 */       for (int i = 0; i < agg_bytes6.length; i++) {
/* 261 */         int agg_hash7 = agg_bytes6[i];
/* 262 */         agg_result6 = (agg_result6 ^ (0x9e3779b9)) + agg_hash7 + (agg_result6 << 6) + (agg_result6 >>> 2);
/* 263 */       }
/* 264 */
/* 265 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result6 + (agg_hash << 6) + (agg_hash >>> 2);
/* 266 */
/* 267 */       int agg_result7 = agg_key7;
/* 268 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result7 + (agg_hash << 6) + (agg_hash >>> 2);
/* 269 */
/* 270 */       return agg_hash;
/* 271 */     }
/* 272 */
/* 273 */     public org.apache.spark.unsafe.KVIterator<UnsafeRow, UnsafeRow> rowIterator() {
/* 274 */       return batch.rowIterator();
/* 275 */     }
/* 276 */
/* 277 */     public void close() {
/* 278 */       batch.close();
/* 279 */     }
/* 280 */
/* 281 */   }
/* 282 */
/* 283 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 284 */     agg_hashMap = agg_plan.createHashMap();
/* 285 */
/* 286 */     while (findNextInnerJoinRows(smj_leftInput, smj_rightInput)) {
/* 287 */       smj_isNull2 = smj_leftRow.isNullAt(0);
/* 288 */       smj_value4 = smj_isNull2 ? -1 : (smj_leftRow.getInt(0));
/* 289 */       smj_isNull3 = smj_leftRow.isNullAt(1);
/* 290 */       smj_value5 = smj_isNull3 ? null : (smj_leftRow.getUTF8String(1));
/* 291 */       smj_isNull4 = smj_leftRow.isNullAt(2);
/* 292 */       smj_value6 = smj_isNull4 ? null : (smj_leftRow.getUTF8String(2));
/* 293 */       smj_isNull5 = smj_leftRow.isNullAt(3);
/* 294 */       smj_value7 = smj_isNull5 ? null : (smj_leftRow.getUTF8String(3));
/* 295 */       smj_isNull6 = smj_leftRow.isNullAt(4);
/* 296 */       smj_value8 = smj_isNull6 ? null : (smj_leftRow.getUTF8String(4));
/* 297 */       smj_isNull7 = smj_leftRow.isNullAt(5);
/* 298 */       smj_value9 = smj_isNull7 ? null : (smj_leftRow.getUTF8String(5));
/* 299 */       smj_isNull8 = smj_leftRow.isNullAt(6);
/* 300 */       smj_value10 = smj_isNull8 ? null : (smj_leftRow.getUTF8String(6));
/* 301 */       smj_isNull9 = smj_leftRow.isNullAt(7);
/* 302 */       smj_value11 = smj_isNull9 ? null : (smj_leftRow.getUTF8String(7));
/* 303 */       scala.collection.Iterator<UnsafeRow> smj_iterator = smj_matches.generateIterator();
/* 304 */       while (smj_iterator.hasNext()) {
/* 305 */         InternalRow smj_rightRow1 = (InternalRow) smj_iterator.next();
/* 306 */
/* 307 */         smj_numOutputRows.add(1);
/* 308 */
/* 309 */         boolean smj_isNull15 = smj_rightRow1.isNullAt(5);
/* 310 */         int smj_value17 = smj_isNull15 ? -1 : (smj_rightRow1.getInt(5));
/* 311 */
/* 312 */         // generate join key for stream side
/* 313 */
/* 314 */         boolean bhj_isNull = smj_isNull15;
/* 315 */         long bhj_value = -1L;
/* 316 */         if (!smj_isNull15) {
/* 317 */           bhj_value = (long) smj_value17;
/* 318 */         }
/* 319 */         // find matches from HashedRelation
/* 320 */         UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 321 */         if (bhj_matched == null) continue;
/* 322 */
/* 323 */         bhj_numOutputRows.add(1);
/* 324 */
/* 325 */         boolean smj_isNull11 = smj_rightRow1.isNullAt(1);
/* 326 */         double smj_value13 = smj_isNull11 ? -1.0 : (smj_rightRow1.getDouble(1));
/* 327 */         boolean smj_isNull12 = smj_rightRow1.isNullAt(2);
/* 328 */         double smj_value14 = smj_isNull12 ? -1.0 : (smj_rightRow1.getDouble(2));
/* 329 */         boolean smj_isNull13 = smj_rightRow1.isNullAt(3);
/* 330 */         double smj_value15 = smj_isNull13 ? -1.0 : (smj_rightRow1.getDouble(3));
/* 331 */         boolean smj_isNull14 = smj_rightRow1.isNullAt(4);
/* 332 */         double smj_value16 = smj_isNull14 ? -1.0 : (smj_rightRow1.getDouble(4));
/* 333 */         boolean bhj_isNull3 = bhj_matched.isNullAt(1);
/* 334 */         int bhj_value3 = bhj_isNull3 ? -1 : (bhj_matched.getInt(1));
/* 335 */
/* 336 */         UnsafeRow agg_unsafeRowAggBuffer = null;
/* 337 */
/* 338 */         UnsafeRow agg_fastAggBuffer = null;
/* 339 */
/* 340 */         if (true) {
/* 341 */           if (!smj_isNull3 && !smj_isNull4 && !smj_isNull5 && !smj_isNull6 && !smj_isNull7 && !smj_isNull8 && !smj_isNull9 && !bhj_isNull3) {
/* 342 */             agg_fastAggBuffer = agg_fastHashMap.findOrInsert(
/* 343 */               smj_value5, smj_value6, smj_value7, smj_value8, smj_value9, smj_value10, smj_value11, bhj_value3);
/* 344 */           }
/* 345 */         }
/* 346 */
/* 347 */         if (agg_fastAggBuffer == null) {
/* 348 */           // generate grouping key
/* 349 */           agg_holder.reset();
/* 350 */
/* 351 */           agg_rowWriter.zeroOutNullBytes();
/* 352 */
/* 353 */           if (smj_isNull3) {
/* 354 */             agg_rowWriter.setNullAt(0);
/* 355 */           } else {
/* 356 */             agg_rowWriter.write(0, smj_value5);
/* 357 */           }
/* 358 */
/* 359 */           if (smj_isNull4) {
/* 360 */             agg_rowWriter.setNullAt(1);
/* 361 */           } else {
/* 362 */             agg_rowWriter.write(1, smj_value6);
/* 363 */           }
/* 364 */
/* 365 */           if (smj_isNull5) {
/* 366 */             agg_rowWriter.setNullAt(2);
/* 367 */           } else {
/* 368 */             agg_rowWriter.write(2, smj_value7);
/* 369 */           }
/* 370 */
/* 371 */           if (smj_isNull6) {
/* 372 */             agg_rowWriter.setNullAt(3);
/* 373 */           } else {
/* 374 */             agg_rowWriter.write(3, smj_value8);
/* 375 */           }
/* 376 */
/* 377 */           if (smj_isNull7) {
/* 378 */             agg_rowWriter.setNullAt(4);
/* 379 */           } else {
/* 380 */             agg_rowWriter.write(4, smj_value9);
/* 381 */           }
/* 382 */
/* 383 */           if (smj_isNull8) {
/* 384 */             agg_rowWriter.setNullAt(5);
/* 385 */           } else {
/* 386 */             agg_rowWriter.write(5, smj_value10);
/* 387 */           }
/* 388 */
/* 389 */           if (smj_isNull9) {
/* 390 */             agg_rowWriter.setNullAt(6);
/* 391 */           } else {
/* 392 */             agg_rowWriter.write(6, smj_value11);
/* 393 */           }
/* 394 */
/* 395 */           if (bhj_isNull3) {
/* 396 */             agg_rowWriter.setNullAt(7);
/* 397 */           } else {
/* 398 */             agg_rowWriter.write(7, bhj_value3);
/* 399 */           }
/* 400 */           agg_result8.setTotalSize(agg_holder.totalSize());
/* 401 */           agg_value18 = 42;
/* 402 */
/* 403 */           if (!smj_isNull3) {
/* 404 */             agg_value18 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(smj_value5.getBaseObject(), smj_value5.getBaseOffset(), smj_value5.numBytes(), agg_value18);
/* 405 */           }
/* 406 */
/* 407 */           if (!smj_isNull4) {
/* 408 */             agg_value18 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(smj_value6.getBaseObject(), smj_value6.getBaseOffset(), smj_value6.numBytes(), agg_value18);
/* 409 */           }
/* 410 */
/* 411 */           if (!smj_isNull5) {
/* 412 */             agg_value18 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(smj_value7.getBaseObject(), smj_value7.getBaseOffset(), smj_value7.numBytes(), agg_value18);
/* 413 */           }
/* 414 */
/* 415 */           if (!smj_isNull6) {
/* 416 */             agg_value18 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(smj_value8.getBaseObject(), smj_value8.getBaseOffset(), smj_value8.numBytes(), agg_value18);
/* 417 */           }
/* 418 */
/* 419 */           if (!smj_isNull7) {
/* 420 */             agg_value18 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(smj_value9.getBaseObject(), smj_value9.getBaseOffset(), smj_value9.numBytes(), agg_value18);
/* 421 */           }
/* 422 */
/* 423 */           if (!smj_isNull8) {
/* 424 */             agg_value18 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(smj_value10.getBaseObject(), smj_value10.getBaseOffset(), smj_value10.numBytes(), agg_value18);
/* 425 */           }
/* 426 */
/* 427 */           if (!smj_isNull9) {
/* 428 */             agg_value18 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(smj_value11.getBaseObject(), smj_value11.getBaseOffset(), smj_value11.numBytes(), agg_value18);
/* 429 */           }
/* 430 */
/* 431 */           if (!bhj_isNull3) {
/* 432 */             agg_value18 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(bhj_value3, agg_value18);
/* 433 */           }
/* 434 */           if (true) {
/* 435 */             // try to get the buffer from hash map
/* 436 */             agg_unsafeRowAggBuffer =
/* 437 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result8, agg_value18);
/* 438 */           }
/* 439 */           if (agg_unsafeRowAggBuffer == null) {
/* 440 */             if (agg_sorter == null) {
/* 441 */               agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 442 */             } else {
/* 443 */               agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 444 */             }
/* 445 */
/* 446 */             // the hash map had be spilled, it should have enough memory now,
/* 447 */             // try  to allocate buffer again.
/* 448 */             agg_unsafeRowAggBuffer =
/* 449 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result8, agg_value18);
/* 450 */             if (agg_unsafeRowAggBuffer == null) {
/* 451 */               // failed to allocate the first page
/* 452 */               throw new OutOfMemoryError("No enough memory for aggregation");
/* 453 */             }
/* 454 */           }
/* 455 */         }
/* 456 */
/* 457 */         if (agg_fastAggBuffer != null) {
/* 458 */           // update fast row
/* 459 */
/* 460 */           // common sub-expressions
/* 461 */
/* 462 */           // evaluate aggregate function
/* 463 */           boolean agg_isNull43 = true;
/* 464 */           double agg_value44 = -1.0;
/* 465 */
/* 466 */           boolean agg_isNull45 = agg_fastAggBuffer.isNullAt(0);
/* 467 */           double agg_value46 = agg_isNull45 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 468 */           boolean agg_isNull44 = agg_isNull45;
/* 469 */           double agg_value45 = agg_value46;
/* 470 */           if (agg_isNull44) {
/* 471 */             boolean agg_isNull46 = false;
/* 472 */             double agg_value47 = -1.0;
/* 473 */             if (!false) {
/* 474 */               agg_value47 = (double) 0;
/* 475 */             }
/* 476 */             if (!agg_isNull46) {
/* 477 */               agg_isNull44 = false;
/* 478 */               agg_value45 = agg_value47;
/* 479 */             }
/* 480 */           }
/* 481 */
/* 482 */           boolean agg_isNull48 = false;
/* 483 */           double agg_value49 = -1.0;
/* 484 */           if (false || 2.0D == 0) {
/* 485 */             agg_isNull48 = true;
/* 486 */           } else {
/* 487 */             boolean agg_isNull49 = true;
/* 488 */             double agg_value50 = -1.0;
/* 489 */
/* 490 */             boolean agg_isNull50 = true;
/* 491 */             double agg_value51 = -1.0;
/* 492 */
/* 493 */             boolean agg_isNull51 = true;
/* 494 */             double agg_value52 = -1.0;
/* 495 */
/* 496 */             if (!smj_isNull14) {
/* 497 */               if (!smj_isNull13) {
/* 498 */                 agg_isNull51 = false; // resultCode could change nullability.
/* 499 */                 agg_value52 = smj_value16 - smj_value15;
/* 500 */
/* 501 */               }
/* 502 */
/* 503 */             }
/* 504 */             if (!agg_isNull51) {
/* 505 */               if (!smj_isNull11) {
/* 506 */                 agg_isNull50 = false; // resultCode could change nullability.
/* 507 */                 agg_value51 = agg_value52 - smj_value13;
/* 508 */
/* 509 */               }
/* 510 */
/* 511 */             }
/* 512 */             if (!agg_isNull50) {
/* 513 */               if (!smj_isNull12) {
/* 514 */                 agg_isNull49 = false; // resultCode could change nullability.
/* 515 */                 agg_value50 = agg_value51 + smj_value14;
/* 516 */
/* 517 */               }
/* 518 */
/* 519 */             }
/* 520 */             if (agg_isNull49) {
/* 521 */               agg_isNull48 = true;
/* 522 */             } else {
/* 523 */               agg_value49 = (double)(agg_value50 / 2.0D);
/* 524 */             }
/* 525 */           }
/* 526 */           if (!agg_isNull48) {
/* 527 */             agg_isNull43 = false; // resultCode could change nullability.
/* 528 */             agg_value44 = agg_value45 + agg_value49;
/* 529 */
/* 530 */           }
/* 531 */           boolean agg_isNull42 = agg_isNull43;
/* 532 */           double agg_value43 = agg_value44;
/* 533 */           if (agg_isNull42) {
/* 534 */             boolean agg_isNull57 = agg_fastAggBuffer.isNullAt(0);
/* 535 */             double agg_value58 = agg_isNull57 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 536 */             if (!agg_isNull57) {
/* 537 */               agg_isNull42 = false;
/* 538 */               agg_value43 = agg_value58;
/* 539 */             }
/* 540 */           }
/* 541 */           // update fast row
/* 542 */           if (!agg_isNull42) {
/* 543 */             agg_fastAggBuffer.setDouble(0, agg_value43);
/* 544 */           } else {
/* 545 */             agg_fastAggBuffer.setNullAt(0);
/* 546 */           }
/* 547 */
/* 548 */         } else {
/* 549 */           // update unsafe row
/* 550 */
/* 551 */           // common sub-expressions
/* 552 */
/* 553 */           // evaluate aggregate function
/* 554 */           boolean agg_isNull27 = true;
/* 555 */           double agg_value28 = -1.0;
/* 556 */
/* 557 */           boolean agg_isNull29 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 558 */           double agg_value30 = agg_isNull29 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 559 */           boolean agg_isNull28 = agg_isNull29;
/* 560 */           double agg_value29 = agg_value30;
/* 561 */           if (agg_isNull28) {
/* 562 */             boolean agg_isNull30 = false;
/* 563 */             double agg_value31 = -1.0;
/* 564 */             if (!false) {
/* 565 */               agg_value31 = (double) 0;
/* 566 */             }
/* 567 */             if (!agg_isNull30) {
/* 568 */               agg_isNull28 = false;
/* 569 */               agg_value29 = agg_value31;
/* 570 */             }
/* 571 */           }
/* 572 */
/* 573 */           boolean agg_isNull32 = false;
/* 574 */           double agg_value33 = -1.0;
/* 575 */           if (false || 2.0D == 0) {
/* 576 */             agg_isNull32 = true;
/* 577 */           } else {
/* 578 */             boolean agg_isNull33 = true;
/* 579 */             double agg_value34 = -1.0;
/* 580 */
/* 581 */             boolean agg_isNull34 = true;
/* 582 */             double agg_value35 = -1.0;
/* 583 */
/* 584 */             boolean agg_isNull35 = true;
/* 585 */             double agg_value36 = -1.0;
/* 586 */
/* 587 */             if (!smj_isNull14) {
/* 588 */               if (!smj_isNull13) {
/* 589 */                 agg_isNull35 = false; // resultCode could change nullability.
/* 590 */                 agg_value36 = smj_value16 - smj_value15;
/* 591 */
/* 592 */               }
/* 593 */
/* 594 */             }
/* 595 */             if (!agg_isNull35) {
/* 596 */               if (!smj_isNull11) {
/* 597 */                 agg_isNull34 = false; // resultCode could change nullability.
/* 598 */                 agg_value35 = agg_value36 - smj_value13;
/* 599 */
/* 600 */               }
/* 601 */
/* 602 */             }
/* 603 */             if (!agg_isNull34) {
/* 604 */               if (!smj_isNull12) {
/* 605 */                 agg_isNull33 = false; // resultCode could change nullability.
/* 606 */                 agg_value34 = agg_value35 + smj_value14;
/* 607 */
/* 608 */               }
/* 609 */
/* 610 */             }
/* 611 */             if (agg_isNull33) {
/* 612 */               agg_isNull32 = true;
/* 613 */             } else {
/* 614 */               agg_value33 = (double)(agg_value34 / 2.0D);
/* 615 */             }
/* 616 */           }
/* 617 */           if (!agg_isNull32) {
/* 618 */             agg_isNull27 = false; // resultCode could change nullability.
/* 619 */             agg_value28 = agg_value29 + agg_value33;
/* 620 */
/* 621 */           }
/* 622 */           boolean agg_isNull26 = agg_isNull27;
/* 623 */           double agg_value27 = agg_value28;
/* 624 */           if (agg_isNull26) {
/* 625 */             boolean agg_isNull41 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 626 */             double agg_value42 = agg_isNull41 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 627 */             if (!agg_isNull41) {
/* 628 */               agg_isNull26 = false;
/* 629 */               agg_value27 = agg_value42;
/* 630 */             }
/* 631 */           }
/* 632 */           // update unsafe row buffer
/* 633 */           if (!agg_isNull26) {
/* 634 */             agg_unsafeRowAggBuffer.setDouble(0, agg_value27);
/* 635 */           } else {
/* 636 */             agg_unsafeRowAggBuffer.setNullAt(0);
/* 637 */           }
/* 638 */
/* 639 */         }
/* 640 */
/* 641 */       }
/* 642 */       if (shouldStop()) return;
/* 643 */     }
/* 644 */
/* 645 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 646 */
/* 647 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 648 */   }
/* 649 */
/* 650 */   private boolean findNextInnerJoinRows(
/* 651 */     scala.collection.Iterator leftIter,
/* 652 */     scala.collection.Iterator rightIter) {
/* 653 */     smj_leftRow = null;
/* 654 */     int comp = 0;
/* 655 */     while (smj_leftRow == null) {
/* 656 */       if (!leftIter.hasNext()) return false;
/* 657 */       smj_leftRow = (InternalRow) leftIter.next();
/* 658 */
/* 659 */       boolean smj_isNull = smj_leftRow.isNullAt(0);
/* 660 */       int smj_value = smj_isNull ? -1 : (smj_leftRow.getInt(0));
/* 661 */       if (smj_isNull) {
/* 662 */         smj_leftRow = null;
/* 663 */         continue;
/* 664 */       }
/* 665 */       if (!smj_matches.isEmpty()) {
/* 666 */         comp = 0;
/* 667 */         if (comp == 0) {
/* 668 */           comp = (smj_value > smj_value3 ? 1 : smj_value < smj_value3 ? -1 : 0);
/* 669 */         }
/* 670 */
/* 671 */         if (comp == 0) {
/* 672 */           return true;
/* 673 */         }
/* 674 */         smj_matches.clear();
/* 675 */       }
/* 676 */
/* 677 */       do {
/* 678 */         if (smj_rightRow == null) {
/* 679 */           if (!rightIter.hasNext()) {
/* 680 */             smj_value3 = smj_value;
/* 681 */             return !smj_matches.isEmpty();
/* 682 */           }
/* 683 */           smj_rightRow = (InternalRow) rightIter.next();
/* 684 */
/* 685 */           boolean smj_isNull1 = smj_rightRow.isNullAt(0);
/* 686 */           int smj_value1 = smj_isNull1 ? -1 : (smj_rightRow.getInt(0));
/* 687 */           if (smj_isNull1) {
/* 688 */             smj_rightRow = null;
/* 689 */             continue;
/* 690 */           }
/* 691 */           smj_value2 = smj_value1;
/* 692 */         }
/* 693 */
/* 694 */         comp = 0;
/* 695 */         if (comp == 0) {
/* 696 */           comp = (smj_value > smj_value2 ? 1 : smj_value < smj_value2 ? -1 : 0);
/* 697 */         }
/* 698 */
/* 699 */         if (comp > 0) {
/* 700 */           smj_rightRow = null;
/* 701 */         } else if (comp < 0) {
/* 702 */           if (!smj_matches.isEmpty()) {
/* 703 */             smj_value3 = smj_value;
/* 704 */             return true;
/* 705 */           }
/* 706 */           smj_leftRow = null;
/* 707 */         } else {
/* 708 */           smj_matches.add((UnsafeRow) smj_rightRow);
/* 709 */           smj_rightRow = null;;
/* 710 */         }
/* 711 */       } while (smj_leftRow != null);
/* 712 */     }
/* 713 */     return false; // unreachable
/* 714 */   }
/* 715 */
/* 716 */   private void wholestagecodegen_init_2() {
/* 717 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 8);
/* 718 */
/* 719 */     agg_unsafeRowJoiner = agg_plan.createUnsafeJoiner();
/* 720 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[15];
/* 721 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[16];
/* 722 */
/* 723 */   }
/* 724 */
/* 725 */   private void wholestagecodegen_init_1() {
/* 726 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 12);
/* 727 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[13];
/* 728 */
/* 729 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 730 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 731 */
/* 732 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[14];
/* 733 */     bhj_result = new UnsafeRow(14);
/* 734 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 224);
/* 735 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 14);
/* 736 */     project_result1 = new UnsafeRow(12);
/* 737 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 224);
/* 738 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 12);
/* 739 */     agg_result8 = new UnsafeRow(8);
/* 740 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result8, 224);
/* 741 */
/* 742 */   }
/* 743 */
/* 744 */   protected void processNext() throws java.io.IOException {
/* 745 */     if (!agg_initAgg) {
/* 746 */       agg_initAgg = true;
/* 747 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 748 */       agg_doAggregateWithKeys();
/* 749 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 750 */     }
/* 751 */
/* 752 */     // output the result
/* 753 */
/* 754 */     while (agg_fastHashMapIter.next()) {
/* 755 */       wholestagecodegen_numOutputRows.add(1);
/* 756 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 757 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 758 */
/* 759 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 760 */
/* 761 */       append(agg_resultRow.copy());
/* 762 */
/* 763 */       if (shouldStop()) return;
/* 764 */     }
/* 765 */     agg_fastHashMap.close();
/* 766 */
/* 767 */     while (agg_mapIter.next()) {
/* 768 */       wholestagecodegen_numOutputRows.add(1);
/* 769 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 770 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 771 */
/* 772 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 773 */
/* 774 */       append(agg_resultRow.copy());
/* 775 */
/* 776 */       if (shouldStop()) return;
/* 777 */     }
/* 778 */
/* 779 */     agg_mapIter.close();
/* 780 */     if (agg_sorter == null) {
/* 781 */       agg_hashMap.free();
/* 782 */     }
/* 783 */   }
/* 784 */ }
