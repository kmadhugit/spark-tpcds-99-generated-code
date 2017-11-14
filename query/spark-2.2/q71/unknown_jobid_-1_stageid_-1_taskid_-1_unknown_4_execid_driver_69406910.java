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
/* 012 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap;
/* 013 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter;
/* 014 */   private org.apache.spark.unsafe.KVIterator agg_mapIter;
/* 015 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory;
/* 016 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize;
/* 017 */   private scala.collection.Iterator inputadapter_input;
/* 018 */   private UnsafeRow agg_result;
/* 019 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 020 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 021 */   private int agg_value10;
/* 022 */   private UnsafeRow agg_result1;
/* 023 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder1;
/* 024 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter1;
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
/* 038 */
/* 039 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 040 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 041 */     inputadapter_input = inputs[0];
/* 042 */     agg_result = new UnsafeRow(4);
/* 043 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result, 32);
/* 044 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 4);
/* 045 */
/* 046 */     agg_result1 = new UnsafeRow(5);
/* 047 */     this.agg_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 32);
/* 048 */     this.agg_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder1, 5);
/* 049 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[3];
/* 050 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 051 */
/* 052 */   }
/* 053 */
/* 054 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 055 */     agg_hashMap = agg_plan.createHashMap();
/* 056 */
/* 057 */     while (inputadapter_input.hasNext() && !stopEarly()) {
/* 058 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 059 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 060 */       UTF8String inputadapter_value = inputadapter_isNull ? null : (inputadapter_row.getUTF8String(0));
/* 061 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 062 */       int inputadapter_value1 = inputadapter_isNull1 ? -1 : (inputadapter_row.getInt(1));
/* 063 */       boolean inputadapter_isNull2 = inputadapter_row.isNullAt(2);
/* 064 */       int inputadapter_value2 = inputadapter_isNull2 ? -1 : (inputadapter_row.getInt(2));
/* 065 */       boolean inputadapter_isNull3 = inputadapter_row.isNullAt(3);
/* 066 */       int inputadapter_value3 = inputadapter_isNull3 ? -1 : (inputadapter_row.getInt(3));
/* 067 */       boolean inputadapter_isNull4 = inputadapter_row.isNullAt(4);
/* 068 */       double inputadapter_value4 = inputadapter_isNull4 ? -1.0 : (inputadapter_row.getDouble(4));
/* 069 */
/* 070 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 071 */
/* 072 */       UnsafeRow agg_fastAggBuffer = null;
/* 073 */
/* 074 */       if (agg_fastAggBuffer == null) {
/* 075 */         // generate grouping key
/* 076 */         agg_holder.reset();
/* 077 */
/* 078 */         agg_rowWriter.zeroOutNullBytes();
/* 079 */
/* 080 */         if (inputadapter_isNull) {
/* 081 */           agg_rowWriter.setNullAt(0);
/* 082 */         } else {
/* 083 */           agg_rowWriter.write(0, inputadapter_value);
/* 084 */         }
/* 085 */
/* 086 */         if (inputadapter_isNull1) {
/* 087 */           agg_rowWriter.setNullAt(1);
/* 088 */         } else {
/* 089 */           agg_rowWriter.write(1, inputadapter_value1);
/* 090 */         }
/* 091 */
/* 092 */         if (inputadapter_isNull2) {
/* 093 */           agg_rowWriter.setNullAt(2);
/* 094 */         } else {
/* 095 */           agg_rowWriter.write(2, inputadapter_value2);
/* 096 */         }
/* 097 */
/* 098 */         if (inputadapter_isNull3) {
/* 099 */           agg_rowWriter.setNullAt(3);
/* 100 */         } else {
/* 101 */           agg_rowWriter.write(3, inputadapter_value3);
/* 102 */         }
/* 103 */         agg_result.setTotalSize(agg_holder.totalSize());
/* 104 */         agg_value10 = 42;
/* 105 */
/* 106 */         if (!inputadapter_isNull) {
/* 107 */           agg_value10 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value.getBaseObject(), inputadapter_value.getBaseOffset(), inputadapter_value.numBytes(), agg_value10);
/* 108 */         }
/* 109 */
/* 110 */         if (!inputadapter_isNull1) {
/* 111 */           agg_value10 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value1, agg_value10);
/* 112 */         }
/* 113 */
/* 114 */         if (!inputadapter_isNull2) {
/* 115 */           agg_value10 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value2, agg_value10);
/* 116 */         }
/* 117 */
/* 118 */         if (!inputadapter_isNull3) {
/* 119 */           agg_value10 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value3, agg_value10);
/* 120 */         }
/* 121 */         if (true) {
/* 122 */           // try to get the buffer from hash map
/* 123 */           agg_unsafeRowAggBuffer =
/* 124 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value10);
/* 125 */         }
/* 126 */         if (agg_unsafeRowAggBuffer == null) {
/* 127 */           if (agg_sorter == null) {
/* 128 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 129 */           } else {
/* 130 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 131 */           }
/* 132 */
/* 133 */           // the hash map had be spilled, it should have enough memory now,
/* 134 */           // try  to allocate buffer again.
/* 135 */           agg_unsafeRowAggBuffer =
/* 136 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value10);
/* 137 */           if (agg_unsafeRowAggBuffer == null) {
/* 138 */             // failed to allocate the first page
/* 139 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 140 */           }
/* 141 */         }
/* 142 */       }
/* 143 */
/* 144 */       if (agg_fastAggBuffer != null) {
/* 145 */         // update fast row
/* 146 */
/* 147 */       } else {
/* 148 */         // update unsafe row
/* 149 */
/* 150 */         // common sub-expressions
/* 151 */
/* 152 */         // evaluate aggregate function
/* 153 */         boolean agg_isNull15 = true;
/* 154 */         double agg_value16 = -1.0;
/* 155 */
/* 156 */         boolean agg_isNull17 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 157 */         double agg_value18 = agg_isNull17 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 158 */         boolean agg_isNull16 = agg_isNull17;
/* 159 */         double agg_value17 = agg_value18;
/* 160 */         if (agg_isNull16) {
/* 161 */           boolean agg_isNull18 = false;
/* 162 */           double agg_value19 = -1.0;
/* 163 */           if (!false) {
/* 164 */             agg_value19 = (double) 0;
/* 165 */           }
/* 166 */           if (!agg_isNull18) {
/* 167 */             agg_isNull16 = false;
/* 168 */             agg_value17 = agg_value19;
/* 169 */           }
/* 170 */         }
/* 171 */
/* 172 */         if (!inputadapter_isNull4) {
/* 173 */           agg_isNull15 = false; // resultCode could change nullability.
/* 174 */           agg_value16 = agg_value17 + inputadapter_value4;
/* 175 */
/* 176 */         }
/* 177 */         boolean agg_isNull14 = agg_isNull15;
/* 178 */         double agg_value15 = agg_value16;
/* 179 */         if (agg_isNull14) {
/* 180 */           boolean agg_isNull21 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 181 */           double agg_value22 = agg_isNull21 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 182 */           if (!agg_isNull21) {
/* 183 */             agg_isNull14 = false;
/* 184 */             agg_value15 = agg_value22;
/* 185 */           }
/* 186 */         }
/* 187 */         // update unsafe row buffer
/* 188 */         if (!agg_isNull14) {
/* 189 */           agg_unsafeRowAggBuffer.setDouble(0, agg_value15);
/* 190 */         } else {
/* 191 */           agg_unsafeRowAggBuffer.setNullAt(0);
/* 192 */         }
/* 193 */
/* 194 */       }
/* 195 */       if (shouldStop()) return;
/* 196 */     }
/* 197 */
/* 198 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 199 */   }
/* 200 */
/* 201 */   protected void processNext() throws java.io.IOException {
/* 202 */     if (!agg_initAgg) {
/* 203 */       agg_initAgg = true;
/* 204 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 205 */       agg_doAggregateWithKeys();
/* 206 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 207 */     }
/* 208 */
/* 209 */     // output the result
/* 210 */
/* 211 */     while (agg_mapIter.next()) {
/* 212 */       wholestagecodegen_numOutputRows.add(1);
/* 213 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 214 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 215 */
/* 216 */       boolean agg_isNull22 = agg_aggKey.isNullAt(0);
/* 217 */       UTF8String agg_value23 = agg_isNull22 ? null : (agg_aggKey.getUTF8String(0));
/* 218 */       boolean agg_isNull23 = agg_aggKey.isNullAt(1);
/* 219 */       int agg_value24 = agg_isNull23 ? -1 : (agg_aggKey.getInt(1));
/* 220 */       boolean agg_isNull24 = agg_aggKey.isNullAt(2);
/* 221 */       int agg_value25 = agg_isNull24 ? -1 : (agg_aggKey.getInt(2));
/* 222 */       boolean agg_isNull25 = agg_aggKey.isNullAt(3);
/* 223 */       int agg_value26 = agg_isNull25 ? -1 : (agg_aggKey.getInt(3));
/* 224 */       boolean agg_isNull26 = agg_aggBuffer.isNullAt(0);
/* 225 */       double agg_value27 = agg_isNull26 ? -1.0 : (agg_aggBuffer.getDouble(0));
/* 226 */
/* 227 */       agg_holder1.reset();
/* 228 */
/* 229 */       agg_rowWriter1.zeroOutNullBytes();
/* 230 */
/* 231 */       if (agg_isNull23) {
/* 232 */         agg_rowWriter1.setNullAt(0);
/* 233 */       } else {
/* 234 */         agg_rowWriter1.write(0, agg_value24);
/* 235 */       }
/* 236 */
/* 237 */       if (agg_isNull22) {
/* 238 */         agg_rowWriter1.setNullAt(1);
/* 239 */       } else {
/* 240 */         agg_rowWriter1.write(1, agg_value23);
/* 241 */       }
/* 242 */
/* 243 */       if (agg_isNull24) {
/* 244 */         agg_rowWriter1.setNullAt(2);
/* 245 */       } else {
/* 246 */         agg_rowWriter1.write(2, agg_value25);
/* 247 */       }
/* 248 */
/* 249 */       if (agg_isNull25) {
/* 250 */         agg_rowWriter1.setNullAt(3);
/* 251 */       } else {
/* 252 */         agg_rowWriter1.write(3, agg_value26);
/* 253 */       }
/* 254 */
/* 255 */       if (agg_isNull26) {
/* 256 */         agg_rowWriter1.setNullAt(4);
/* 257 */       } else {
/* 258 */         agg_rowWriter1.write(4, agg_value27);
/* 259 */       }
/* 260 */       agg_result1.setTotalSize(agg_holder1.totalSize());
/* 261 */       append(agg_result1);
/* 262 */
/* 263 */       if (shouldStop()) return;
/* 264 */     }
/* 265 */
/* 266 */     agg_mapIter.close();
/* 267 */     if (agg_sorter == null) {
/* 268 */       agg_hashMap.free();
/* 269 */     }
/* 270 */   }
/* 271 */ }
