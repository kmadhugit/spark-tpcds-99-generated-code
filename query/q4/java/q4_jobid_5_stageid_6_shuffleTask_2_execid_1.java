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
/* 019 */   private scala.collection.Iterator inputadapter_input;
/* 020 */   private UnsafeRow agg_result8;
/* 021 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 022 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 023 */   private int agg_value18;
/* 024 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowJoiner agg_unsafeRowJoiner;
/* 025 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 026 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 027 */
/* 028 */   public GeneratedIterator(Object[] references) {
/* 029 */     this.references = references;
/* 030 */   }
/* 031 */
/* 032 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 033 */     partitionIndex = index;
/* 034 */     this.inputs = inputs;
/* 035 */     agg_initAgg = false;
/* 036 */
/* 037 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 038 */     agg_fastHashMap = new agg_FastHashMap(agg_plan.getTaskMemoryManager(), agg_plan.getEmptyAggregationBuffer());
/* 039 */
/* 040 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 041 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 042 */     inputadapter_input = inputs[0];
/* 043 */     agg_result8 = new UnsafeRow(8);
/* 044 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result8, 224);
/* 045 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 8);
/* 046 */
/* 047 */     agg_unsafeRowJoiner = agg_plan.createUnsafeJoiner();
/* 048 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[3];
/* 049 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 050 */
/* 051 */   }
/* 052 */
/* 053 */   public class agg_FastHashMap {
/* 054 */     private org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch batch;
/* 055 */     private int[] buckets;
/* 056 */     private int capacity = 1 << 16;
/* 057 */     private double loadFactor = 0.5;
/* 058 */     private int numBuckets = (int) (capacity / loadFactor);
/* 059 */     private int maxSteps = 2;
/* 060 */     private int numRows = 0;
/* 061 */     private org.apache.spark.sql.types.StructType keySchema = new org.apache.spark.sql.types.StructType().add("c_customer_id", org.apache.spark.sql.types.DataTypes.StringType)
/* 062 */     .add("c_first_name", org.apache.spark.sql.types.DataTypes.StringType)
/* 063 */     .add("c_last_name", org.apache.spark.sql.types.DataTypes.StringType)
/* 064 */     .add("c_preferred_cust_flag", org.apache.spark.sql.types.DataTypes.StringType)
/* 065 */     .add("c_birth_country", org.apache.spark.sql.types.DataTypes.StringType)
/* 066 */     .add("c_login", org.apache.spark.sql.types.DataTypes.StringType)
/* 067 */     .add("c_email_address", org.apache.spark.sql.types.DataTypes.StringType)
/* 068 */     .add("d_year", org.apache.spark.sql.types.DataTypes.IntegerType);
/* 069 */     private org.apache.spark.sql.types.StructType valueSchema = new org.apache.spark.sql.types.StructType().add("sum", org.apache.spark.sql.types.DataTypes.DoubleType);
/* 070 */     private Object emptyVBase;
/* 071 */     private long emptyVOff;
/* 072 */     private int emptyVLen;
/* 073 */     private boolean isBatchFull = false;
/* 074 */
/* 075 */     public agg_FastHashMap(
/* 076 */       org.apache.spark.memory.TaskMemoryManager taskMemoryManager,
/* 077 */       InternalRow emptyAggregationBuffer) {
/* 078 */       batch = org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch
/* 079 */       .allocate(keySchema, valueSchema, taskMemoryManager, capacity);
/* 080 */
/* 081 */       final UnsafeProjection valueProjection = UnsafeProjection.create(valueSchema);
/* 082 */       final byte[] emptyBuffer = valueProjection.apply(emptyAggregationBuffer).getBytes();
/* 083 */
/* 084 */       emptyVBase = emptyBuffer;
/* 085 */       emptyVOff = Platform.BYTE_ARRAY_OFFSET;
/* 086 */       emptyVLen = emptyBuffer.length;
/* 087 */
/* 088 */       buckets = new int[numBuckets];
/* 089 */       java.util.Arrays.fill(buckets, -1);
/* 090 */     }
/* 091 */
/* 092 */     public org.apache.spark.sql.catalyst.expressions.UnsafeRow findOrInsert(UTF8String agg_key, UTF8String agg_key1, UTF8String agg_key2, UTF8String agg_key3, UTF8String agg_key4, UTF8String agg_key5, UTF8String agg_key6, int agg_key7) {
/* 093 */       long h = hash(agg_key, agg_key1, agg_key2, agg_key3, agg_key4, agg_key5, agg_key6, agg_key7);
/* 094 */       int step = 0;
/* 095 */       int idx = (int) h & (numBuckets - 1);
/* 096 */       while (step < maxSteps) {
/* 097 */         // Return bucket index if it's either an empty slot or already contains the key
/* 098 */         if (buckets[idx] == -1) {
/* 099 */           if (numRows < capacity && !isBatchFull) {
/* 100 */             // creating the unsafe for new entry
/* 101 */             UnsafeRow agg_result = new UnsafeRow(8);
/* 102 */             org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder
/* 103 */             = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result,
/* 104 */               224);
/* 105 */             org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter
/* 106 */             = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(
/* 107 */               agg_holder,
/* 108 */               8);
/* 109 */             agg_holder.reset(); //TODO: investigate if reset or zeroout are actually needed
/* 110 */             agg_rowWriter.zeroOutNullBytes();
/* 111 */             agg_rowWriter.write(0, agg_key);
/* 112 */             agg_rowWriter.write(1, agg_key1);
/* 113 */             agg_rowWriter.write(2, agg_key2);
/* 114 */             agg_rowWriter.write(3, agg_key3);
/* 115 */             agg_rowWriter.write(4, agg_key4);
/* 116 */             agg_rowWriter.write(5, agg_key5);
/* 117 */             agg_rowWriter.write(6, agg_key6);
/* 118 */             agg_rowWriter.write(7, agg_key7);
/* 119 */             agg_result.setTotalSize(agg_holder.totalSize());
/* 120 */             Object kbase = agg_result.getBaseObject();
/* 121 */             long koff = agg_result.getBaseOffset();
/* 122 */             int klen = agg_result.getSizeInBytes();
/* 123 */
/* 124 */             UnsafeRow vRow
/* 125 */             = batch.appendRow(kbase, koff, klen, emptyVBase, emptyVOff, emptyVLen);
/* 126 */             if (vRow == null) {
/* 127 */               isBatchFull = true;
/* 128 */             } else {
/* 129 */               buckets[idx] = numRows++;
/* 130 */             }
/* 131 */             return vRow;
/* 132 */           } else {
/* 133 */             // No more space
/* 134 */             return null;
/* 135 */           }
/* 136 */         } else if (equals(idx, agg_key, agg_key1, agg_key2, agg_key3, agg_key4, agg_key5, agg_key6, agg_key7)) {
/* 137 */           return batch.getValueRow(buckets[idx]);
/* 138 */         }
/* 139 */         idx = (idx + 1) & (numBuckets - 1);
/* 140 */         step++;
/* 141 */       }
/* 142 */       // Didn't find it
/* 143 */       return null;
/* 144 */     }
/* 145 */
/* 146 */     private boolean equals(int idx, UTF8String agg_key, UTF8String agg_key1, UTF8String agg_key2, UTF8String agg_key3, UTF8String agg_key4, UTF8String agg_key5, UTF8String agg_key6, int agg_key7) {
/* 147 */       UnsafeRow row = batch.getKeyRow(buckets[idx]);
/* 148 */       return (row.getUTF8String(0).equals(agg_key)) && (row.getUTF8String(1).equals(agg_key1)) && (row.getUTF8String(2).equals(agg_key2)) && (row.getUTF8String(3).equals(agg_key3)) && (row.getUTF8String(4).equals(agg_key4)) && (row.getUTF8String(5).equals(agg_key5)) && (row.getUTF8String(6).equals(agg_key6)) && (row.getInt(7) == agg_key7);
/* 149 */     }
/* 150 */
/* 151 */     private long hash(UTF8String agg_key, UTF8String agg_key1, UTF8String agg_key2, UTF8String agg_key3, UTF8String agg_key4, UTF8String agg_key5, UTF8String agg_key6, int agg_key7) {
/* 152 */       long agg_hash = 0;
/* 153 */
/* 154 */       int agg_result = 0;
/* 155 */       byte[] agg_bytes = agg_key.getBytes();
/* 156 */       for (int i = 0; i < agg_bytes.length; i++) {
/* 157 */         int agg_hash1 = agg_bytes[i];
/* 158 */         agg_result = (agg_result ^ (0x9e3779b9)) + agg_hash1 + (agg_result << 6) + (agg_result >>> 2);
/* 159 */       }
/* 160 */
/* 161 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result + (agg_hash << 6) + (agg_hash >>> 2);
/* 162 */
/* 163 */       int agg_result1 = 0;
/* 164 */       byte[] agg_bytes1 = agg_key1.getBytes();
/* 165 */       for (int i = 0; i < agg_bytes1.length; i++) {
/* 166 */         int agg_hash2 = agg_bytes1[i];
/* 167 */         agg_result1 = (agg_result1 ^ (0x9e3779b9)) + agg_hash2 + (agg_result1 << 6) + (agg_result1 >>> 2);
/* 168 */       }
/* 169 */
/* 170 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result1 + (agg_hash << 6) + (agg_hash >>> 2);
/* 171 */
/* 172 */       int agg_result2 = 0;
/* 173 */       byte[] agg_bytes2 = agg_key2.getBytes();
/* 174 */       for (int i = 0; i < agg_bytes2.length; i++) {
/* 175 */         int agg_hash3 = agg_bytes2[i];
/* 176 */         agg_result2 = (agg_result2 ^ (0x9e3779b9)) + agg_hash3 + (agg_result2 << 6) + (agg_result2 >>> 2);
/* 177 */       }
/* 178 */
/* 179 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result2 + (agg_hash << 6) + (agg_hash >>> 2);
/* 180 */
/* 181 */       int agg_result3 = 0;
/* 182 */       byte[] agg_bytes3 = agg_key3.getBytes();
/* 183 */       for (int i = 0; i < agg_bytes3.length; i++) {
/* 184 */         int agg_hash4 = agg_bytes3[i];
/* 185 */         agg_result3 = (agg_result3 ^ (0x9e3779b9)) + agg_hash4 + (agg_result3 << 6) + (agg_result3 >>> 2);
/* 186 */       }
/* 187 */
/* 188 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result3 + (agg_hash << 6) + (agg_hash >>> 2);
/* 189 */
/* 190 */       int agg_result4 = 0;
/* 191 */       byte[] agg_bytes4 = agg_key4.getBytes();
/* 192 */       for (int i = 0; i < agg_bytes4.length; i++) {
/* 193 */         int agg_hash5 = agg_bytes4[i];
/* 194 */         agg_result4 = (agg_result4 ^ (0x9e3779b9)) + agg_hash5 + (agg_result4 << 6) + (agg_result4 >>> 2);
/* 195 */       }
/* 196 */
/* 197 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result4 + (agg_hash << 6) + (agg_hash >>> 2);
/* 198 */
/* 199 */       int agg_result5 = 0;
/* 200 */       byte[] agg_bytes5 = agg_key5.getBytes();
/* 201 */       for (int i = 0; i < agg_bytes5.length; i++) {
/* 202 */         int agg_hash6 = agg_bytes5[i];
/* 203 */         agg_result5 = (agg_result5 ^ (0x9e3779b9)) + agg_hash6 + (agg_result5 << 6) + (agg_result5 >>> 2);
/* 204 */       }
/* 205 */
/* 206 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result5 + (agg_hash << 6) + (agg_hash >>> 2);
/* 207 */
/* 208 */       int agg_result6 = 0;
/* 209 */       byte[] agg_bytes6 = agg_key6.getBytes();
/* 210 */       for (int i = 0; i < agg_bytes6.length; i++) {
/* 211 */         int agg_hash7 = agg_bytes6[i];
/* 212 */         agg_result6 = (agg_result6 ^ (0x9e3779b9)) + agg_hash7 + (agg_result6 << 6) + (agg_result6 >>> 2);
/* 213 */       }
/* 214 */
/* 215 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result6 + (agg_hash << 6) + (agg_hash >>> 2);
/* 216 */
/* 217 */       int agg_result7 = agg_key7;
/* 218 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result7 + (agg_hash << 6) + (agg_hash >>> 2);
/* 219 */
/* 220 */       return agg_hash;
/* 221 */     }
/* 222 */
/* 223 */     public org.apache.spark.unsafe.KVIterator<UnsafeRow, UnsafeRow> rowIterator() {
/* 224 */       return batch.rowIterator();
/* 225 */     }
/* 226 */
/* 227 */     public void close() {
/* 228 */       batch.close();
/* 229 */     }
/* 230 */
/* 231 */   }
/* 232 */
/* 233 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 234 */     agg_hashMap = agg_plan.createHashMap();
/* 235 */
/* 236 */     while (inputadapter_input.hasNext()) {
/* 237 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 238 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 239 */       UTF8String inputadapter_value = inputadapter_isNull ? null : (inputadapter_row.getUTF8String(0));
/* 240 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 241 */       UTF8String inputadapter_value1 = inputadapter_isNull1 ? null : (inputadapter_row.getUTF8String(1));
/* 242 */       boolean inputadapter_isNull2 = inputadapter_row.isNullAt(2);
/* 243 */       UTF8String inputadapter_value2 = inputadapter_isNull2 ? null : (inputadapter_row.getUTF8String(2));
/* 244 */       boolean inputadapter_isNull3 = inputadapter_row.isNullAt(3);
/* 245 */       UTF8String inputadapter_value3 = inputadapter_isNull3 ? null : (inputadapter_row.getUTF8String(3));
/* 246 */       boolean inputadapter_isNull4 = inputadapter_row.isNullAt(4);
/* 247 */       UTF8String inputadapter_value4 = inputadapter_isNull4 ? null : (inputadapter_row.getUTF8String(4));
/* 248 */       boolean inputadapter_isNull5 = inputadapter_row.isNullAt(5);
/* 249 */       UTF8String inputadapter_value5 = inputadapter_isNull5 ? null : (inputadapter_row.getUTF8String(5));
/* 250 */       boolean inputadapter_isNull6 = inputadapter_row.isNullAt(6);
/* 251 */       UTF8String inputadapter_value6 = inputadapter_isNull6 ? null : (inputadapter_row.getUTF8String(6));
/* 252 */       boolean inputadapter_isNull7 = inputadapter_row.isNullAt(7);
/* 253 */       double inputadapter_value7 = inputadapter_isNull7 ? -1.0 : (inputadapter_row.getDouble(7));
/* 254 */       boolean inputadapter_isNull8 = inputadapter_row.isNullAt(8);
/* 255 */       double inputadapter_value8 = inputadapter_isNull8 ? -1.0 : (inputadapter_row.getDouble(8));
/* 256 */       boolean inputadapter_isNull9 = inputadapter_row.isNullAt(9);
/* 257 */       double inputadapter_value9 = inputadapter_isNull9 ? -1.0 : (inputadapter_row.getDouble(9));
/* 258 */       boolean inputadapter_isNull10 = inputadapter_row.isNullAt(10);
/* 259 */       double inputadapter_value10 = inputadapter_isNull10 ? -1.0 : (inputadapter_row.getDouble(10));
/* 260 */       boolean inputadapter_isNull11 = inputadapter_row.isNullAt(11);
/* 261 */       int inputadapter_value11 = inputadapter_isNull11 ? -1 : (inputadapter_row.getInt(11));
/* 262 */
/* 263 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 264 */
/* 265 */       UnsafeRow agg_fastAggBuffer = null;
/* 266 */
/* 267 */       if (true) {
/* 268 */         if (!inputadapter_isNull && !inputadapter_isNull1 && !inputadapter_isNull2 && !inputadapter_isNull3 && !inputadapter_isNull4 && !inputadapter_isNull5 && !inputadapter_isNull6 && !inputadapter_isNull11) {
/* 269 */           agg_fastAggBuffer = agg_fastHashMap.findOrInsert(
/* 270 */             inputadapter_value, inputadapter_value1, inputadapter_value2, inputadapter_value3, inputadapter_value4, inputadapter_value5, inputadapter_value6, inputadapter_value11);
/* 271 */         }
/* 272 */       }
/* 273 */
/* 274 */       if (agg_fastAggBuffer == null) {
/* 275 */         // generate grouping key
/* 276 */         agg_holder.reset();
/* 277 */
/* 278 */         agg_rowWriter.zeroOutNullBytes();
/* 279 */
/* 280 */         if (inputadapter_isNull) {
/* 281 */           agg_rowWriter.setNullAt(0);
/* 282 */         } else {
/* 283 */           agg_rowWriter.write(0, inputadapter_value);
/* 284 */         }
/* 285 */
/* 286 */         if (inputadapter_isNull1) {
/* 287 */           agg_rowWriter.setNullAt(1);
/* 288 */         } else {
/* 289 */           agg_rowWriter.write(1, inputadapter_value1);
/* 290 */         }
/* 291 */
/* 292 */         if (inputadapter_isNull2) {
/* 293 */           agg_rowWriter.setNullAt(2);
/* 294 */         } else {
/* 295 */           agg_rowWriter.write(2, inputadapter_value2);
/* 296 */         }
/* 297 */
/* 298 */         if (inputadapter_isNull3) {
/* 299 */           agg_rowWriter.setNullAt(3);
/* 300 */         } else {
/* 301 */           agg_rowWriter.write(3, inputadapter_value3);
/* 302 */         }
/* 303 */
/* 304 */         if (inputadapter_isNull4) {
/* 305 */           agg_rowWriter.setNullAt(4);
/* 306 */         } else {
/* 307 */           agg_rowWriter.write(4, inputadapter_value4);
/* 308 */         }
/* 309 */
/* 310 */         if (inputadapter_isNull5) {
/* 311 */           agg_rowWriter.setNullAt(5);
/* 312 */         } else {
/* 313 */           agg_rowWriter.write(5, inputadapter_value5);
/* 314 */         }
/* 315 */
/* 316 */         if (inputadapter_isNull6) {
/* 317 */           agg_rowWriter.setNullAt(6);
/* 318 */         } else {
/* 319 */           agg_rowWriter.write(6, inputadapter_value6);
/* 320 */         }
/* 321 */
/* 322 */         if (inputadapter_isNull11) {
/* 323 */           agg_rowWriter.setNullAt(7);
/* 324 */         } else {
/* 325 */           agg_rowWriter.write(7, inputadapter_value11);
/* 326 */         }
/* 327 */         agg_result8.setTotalSize(agg_holder.totalSize());
/* 328 */         agg_value18 = 42;
/* 329 */
/* 330 */         if (!inputadapter_isNull) {
/* 331 */           agg_value18 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value.getBaseObject(), inputadapter_value.getBaseOffset(), inputadapter_value.numBytes(), agg_value18);
/* 332 */         }
/* 333 */
/* 334 */         if (!inputadapter_isNull1) {
/* 335 */           agg_value18 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value1.getBaseObject(), inputadapter_value1.getBaseOffset(), inputadapter_value1.numBytes(), agg_value18);
/* 336 */         }
/* 337 */
/* 338 */         if (!inputadapter_isNull2) {
/* 339 */           agg_value18 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value2.getBaseObject(), inputadapter_value2.getBaseOffset(), inputadapter_value2.numBytes(), agg_value18);
/* 340 */         }
/* 341 */
/* 342 */         if (!inputadapter_isNull3) {
/* 343 */           agg_value18 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value3.getBaseObject(), inputadapter_value3.getBaseOffset(), inputadapter_value3.numBytes(), agg_value18);
/* 344 */         }
/* 345 */
/* 346 */         if (!inputadapter_isNull4) {
/* 347 */           agg_value18 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value4.getBaseObject(), inputadapter_value4.getBaseOffset(), inputadapter_value4.numBytes(), agg_value18);
/* 348 */         }
/* 349 */
/* 350 */         if (!inputadapter_isNull5) {
/* 351 */           agg_value18 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value5.getBaseObject(), inputadapter_value5.getBaseOffset(), inputadapter_value5.numBytes(), agg_value18);
/* 352 */         }
/* 353 */
/* 354 */         if (!inputadapter_isNull6) {
/* 355 */           agg_value18 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value6.getBaseObject(), inputadapter_value6.getBaseOffset(), inputadapter_value6.numBytes(), agg_value18);
/* 356 */         }
/* 357 */
/* 358 */         if (!inputadapter_isNull11) {
/* 359 */           agg_value18 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value11, agg_value18);
/* 360 */         }
/* 361 */         if (true) {
/* 362 */           // try to get the buffer from hash map
/* 363 */           agg_unsafeRowAggBuffer =
/* 364 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result8, agg_value18);
/* 365 */         }
/* 366 */         if (agg_unsafeRowAggBuffer == null) {
/* 367 */           if (agg_sorter == null) {
/* 368 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 369 */           } else {
/* 370 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 371 */           }
/* 372 */
/* 373 */           // the hash map had be spilled, it should have enough memory now,
/* 374 */           // try  to allocate buffer again.
/* 375 */           agg_unsafeRowAggBuffer =
/* 376 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result8, agg_value18);
/* 377 */           if (agg_unsafeRowAggBuffer == null) {
/* 378 */             // failed to allocate the first page
/* 379 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 380 */           }
/* 381 */         }
/* 382 */       }
/* 383 */
/* 384 */       if (agg_fastAggBuffer != null) {
/* 385 */         // update fast row
/* 386 */
/* 387 */         // common sub-expressions
/* 388 */
/* 389 */         // evaluate aggregate function
/* 390 */         boolean agg_isNull44 = true;
/* 391 */         double agg_value45 = -1.0;
/* 392 */
/* 393 */         boolean agg_isNull46 = agg_fastAggBuffer.isNullAt(0);
/* 394 */         double agg_value47 = agg_isNull46 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 395 */         boolean agg_isNull45 = agg_isNull46;
/* 396 */         double agg_value46 = agg_value47;
/* 397 */         if (agg_isNull45) {
/* 398 */           boolean agg_isNull47 = false;
/* 399 */           double agg_value48 = -1.0;
/* 400 */           if (!false) {
/* 401 */             agg_value48 = (double) 0;
/* 402 */           }
/* 403 */           if (!agg_isNull47) {
/* 404 */             agg_isNull45 = false;
/* 405 */             agg_value46 = agg_value48;
/* 406 */           }
/* 407 */         }
/* 408 */
/* 409 */         boolean agg_isNull50 = false;
/* 410 */         double agg_value51 = -1.0;
/* 411 */         if (false || 2.0D == 0) {
/* 412 */           agg_isNull50 = true;
/* 413 */         } else {
/* 414 */           boolean agg_isNull51 = true;
/* 415 */           double agg_value52 = -1.0;
/* 416 */
/* 417 */           boolean agg_isNull52 = true;
/* 418 */           double agg_value53 = -1.0;
/* 419 */
/* 420 */           boolean agg_isNull53 = true;
/* 421 */           double agg_value54 = -1.0;
/* 422 */
/* 423 */           if (!inputadapter_isNull10) {
/* 424 */             if (!inputadapter_isNull9) {
/* 425 */               agg_isNull53 = false; // resultCode could change nullability.
/* 426 */               agg_value54 = inputadapter_value10 - inputadapter_value9;
/* 427 */
/* 428 */             }
/* 429 */
/* 430 */           }
/* 431 */           if (!agg_isNull53) {
/* 432 */             if (!inputadapter_isNull7) {
/* 433 */               agg_isNull52 = false; // resultCode could change nullability.
/* 434 */               agg_value53 = agg_value54 - inputadapter_value7;
/* 435 */
/* 436 */             }
/* 437 */
/* 438 */           }
/* 439 */           if (!agg_isNull52) {
/* 440 */             if (!inputadapter_isNull8) {
/* 441 */               agg_isNull51 = false; // resultCode could change nullability.
/* 442 */               agg_value52 = agg_value53 + inputadapter_value8;
/* 443 */
/* 444 */             }
/* 445 */
/* 446 */           }
/* 447 */           if (agg_isNull51) {
/* 448 */             agg_isNull50 = true;
/* 449 */           } else {
/* 450 */             agg_value51 = (double)(agg_value52 / 2.0D);
/* 451 */           }
/* 452 */         }
/* 453 */         boolean agg_isNull49 = agg_isNull50;
/* 454 */         double agg_value50 = -1.0;
/* 455 */         if (!agg_isNull50) {
/* 456 */           agg_value50 = agg_value51;
/* 457 */         }
/* 458 */         if (!agg_isNull49) {
/* 459 */           agg_isNull44 = false; // resultCode could change nullability.
/* 460 */           agg_value45 = agg_value46 + agg_value50;
/* 461 */
/* 462 */         }
/* 463 */         boolean agg_isNull43 = agg_isNull44;
/* 464 */         double agg_value44 = agg_value45;
/* 465 */         if (agg_isNull43) {
/* 466 */           boolean agg_isNull59 = agg_fastAggBuffer.isNullAt(0);
/* 467 */           double agg_value60 = agg_isNull59 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 468 */           if (!agg_isNull59) {
/* 469 */             agg_isNull43 = false;
/* 470 */             agg_value44 = agg_value60;
/* 471 */           }
/* 472 */         }
/* 473 */         // update fast row
/* 474 */         if (!agg_isNull43) {
/* 475 */           agg_fastAggBuffer.setDouble(0, agg_value44);
/* 476 */         } else {
/* 477 */           agg_fastAggBuffer.setNullAt(0);
/* 478 */         }
/* 479 */
/* 480 */       } else {
/* 481 */         // update unsafe row
/* 482 */
/* 483 */         // common sub-expressions
/* 484 */
/* 485 */         // evaluate aggregate function
/* 486 */         boolean agg_isNull27 = true;
/* 487 */         double agg_value28 = -1.0;
/* 488 */
/* 489 */         boolean agg_isNull29 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 490 */         double agg_value30 = agg_isNull29 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 491 */         boolean agg_isNull28 = agg_isNull29;
/* 492 */         double agg_value29 = agg_value30;
/* 493 */         if (agg_isNull28) {
/* 494 */           boolean agg_isNull30 = false;
/* 495 */           double agg_value31 = -1.0;
/* 496 */           if (!false) {
/* 497 */             agg_value31 = (double) 0;
/* 498 */           }
/* 499 */           if (!agg_isNull30) {
/* 500 */             agg_isNull28 = false;
/* 501 */             agg_value29 = agg_value31;
/* 502 */           }
/* 503 */         }
/* 504 */
/* 505 */         boolean agg_isNull33 = false;
/* 506 */         double agg_value34 = -1.0;
/* 507 */         if (false || 2.0D == 0) {
/* 508 */           agg_isNull33 = true;
/* 509 */         } else {
/* 510 */           boolean agg_isNull34 = true;
/* 511 */           double agg_value35 = -1.0;
/* 512 */
/* 513 */           boolean agg_isNull35 = true;
/* 514 */           double agg_value36 = -1.0;
/* 515 */
/* 516 */           boolean agg_isNull36 = true;
/* 517 */           double agg_value37 = -1.0;
/* 518 */
/* 519 */           if (!inputadapter_isNull10) {
/* 520 */             if (!inputadapter_isNull9) {
/* 521 */               agg_isNull36 = false; // resultCode could change nullability.
/* 522 */               agg_value37 = inputadapter_value10 - inputadapter_value9;
/* 523 */
/* 524 */             }
/* 525 */
/* 526 */           }
/* 527 */           if (!agg_isNull36) {
/* 528 */             if (!inputadapter_isNull7) {
/* 529 */               agg_isNull35 = false; // resultCode could change nullability.
/* 530 */               agg_value36 = agg_value37 - inputadapter_value7;
/* 531 */
/* 532 */             }
/* 533 */
/* 534 */           }
/* 535 */           if (!agg_isNull35) {
/* 536 */             if (!inputadapter_isNull8) {
/* 537 */               agg_isNull34 = false; // resultCode could change nullability.
/* 538 */               agg_value35 = agg_value36 + inputadapter_value8;
/* 539 */
/* 540 */             }
/* 541 */
/* 542 */           }
/* 543 */           if (agg_isNull34) {
/* 544 */             agg_isNull33 = true;
/* 545 */           } else {
/* 546 */             agg_value34 = (double)(agg_value35 / 2.0D);
/* 547 */           }
/* 548 */         }
/* 549 */         boolean agg_isNull32 = agg_isNull33;
/* 550 */         double agg_value33 = -1.0;
/* 551 */         if (!agg_isNull33) {
/* 552 */           agg_value33 = agg_value34;
/* 553 */         }
/* 554 */         if (!agg_isNull32) {
/* 555 */           agg_isNull27 = false; // resultCode could change nullability.
/* 556 */           agg_value28 = agg_value29 + agg_value33;
/* 557 */
/* 558 */         }
/* 559 */         boolean agg_isNull26 = agg_isNull27;
/* 560 */         double agg_value27 = agg_value28;
/* 561 */         if (agg_isNull26) {
/* 562 */           boolean agg_isNull42 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 563 */           double agg_value43 = agg_isNull42 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 564 */           if (!agg_isNull42) {
/* 565 */             agg_isNull26 = false;
/* 566 */             agg_value27 = agg_value43;
/* 567 */           }
/* 568 */         }
/* 569 */         // update unsafe row buffer
/* 570 */         if (!agg_isNull26) {
/* 571 */           agg_unsafeRowAggBuffer.setDouble(0, agg_value27);
/* 572 */         } else {
/* 573 */           agg_unsafeRowAggBuffer.setNullAt(0);
/* 574 */         }
/* 575 */
/* 576 */       }
/* 577 */       if (shouldStop()) return;
/* 578 */     }
/* 579 */
/* 580 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 581 */
/* 582 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 583 */   }
/* 584 */
/* 585 */   protected void processNext() throws java.io.IOException {
/* 586 */     if (!agg_initAgg) {
/* 587 */       agg_initAgg = true;
/* 588 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 589 */       agg_doAggregateWithKeys();
/* 590 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 591 */     }
/* 592 */
/* 593 */     // output the result
/* 594 */
/* 595 */     while (agg_fastHashMapIter.next()) {
/* 596 */       wholestagecodegen_numOutputRows.add(1);
/* 597 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 598 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 599 */
/* 600 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 601 */
/* 602 */       append(agg_resultRow);
/* 603 */
/* 604 */       if (shouldStop()) return;
/* 605 */     }
/* 606 */     agg_fastHashMap.close();
/* 607 */
/* 608 */     while (agg_mapIter.next()) {
/* 609 */       wholestagecodegen_numOutputRows.add(1);
/* 610 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 611 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 612 */
/* 613 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 614 */
/* 615 */       append(agg_resultRow);
/* 616 */
/* 617 */       if (shouldStop()) return;
/* 618 */     }
/* 619 */
/* 620 */     agg_mapIter.close();
/* 621 */     if (agg_sorter == null) {
/* 622 */       agg_hashMap.free();
/* 623 */     }
/* 624 */   }
/* 625 */ }
