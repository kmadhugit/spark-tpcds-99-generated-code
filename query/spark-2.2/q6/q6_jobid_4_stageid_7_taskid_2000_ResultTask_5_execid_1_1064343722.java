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
/* 011 */   private boolean agg_bufIsNull1;
/* 012 */   private long agg_bufValue1;
/* 013 */   private org.apache.spark.sql.execution.aggregate.HashAggregateExec agg_plan;
/* 014 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap;
/* 015 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter;
/* 016 */   private org.apache.spark.unsafe.KVIterator agg_mapIter;
/* 017 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory;
/* 018 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize;
/* 019 */   private scala.collection.Iterator inputadapter_input;
/* 020 */   private UnsafeRow agg_result;
/* 021 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 022 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 023 */   private int agg_value7;
/* 024 */   private UnsafeRow agg_result1;
/* 025 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder1;
/* 026 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter1;
/* 027 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 028 */   private UnsafeRow filter_result;
/* 029 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 030 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 031 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 032 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 033 */
/* 034 */   public GeneratedIterator(Object[] references) {
/* 035 */     this.references = references;
/* 036 */   }
/* 037 */
/* 038 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 039 */     partitionIndex = index;
/* 040 */     this.inputs = inputs;
/* 041 */     wholestagecodegen_init_0();
/* 042 */     wholestagecodegen_init_1();
/* 043 */
/* 044 */   }
/* 045 */
/* 046 */   private void wholestagecodegen_init_0() {
/* 047 */     agg_initAgg = false;
/* 048 */
/* 049 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 050 */
/* 051 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 052 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 053 */     inputadapter_input = inputs[0];
/* 054 */     agg_result = new UnsafeRow(1);
/* 055 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result, 32);
/* 056 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 1);
/* 057 */
/* 058 */     agg_result1 = new UnsafeRow(2);
/* 059 */     this.agg_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 32);
/* 060 */     this.agg_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder1, 2);
/* 061 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[3];
/* 062 */     filter_result = new UnsafeRow(2);
/* 063 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 32);
/* 064 */
/* 065 */   }
/* 066 */
/* 067 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 068 */     agg_hashMap = agg_plan.createHashMap();
/* 069 */
/* 070 */     while (inputadapter_input.hasNext() && !stopEarly()) {
/* 071 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 072 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 073 */       UTF8String inputadapter_value = inputadapter_isNull ? null : (inputadapter_row.getUTF8String(0));
/* 074 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 075 */       double inputadapter_value1 = inputadapter_isNull1 ? -1.0 : (inputadapter_row.getDouble(1));
/* 076 */       boolean inputadapter_isNull2 = inputadapter_row.isNullAt(2);
/* 077 */       long inputadapter_value2 = inputadapter_isNull2 ? -1L : (inputadapter_row.getLong(2));
/* 078 */
/* 079 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 080 */
/* 081 */       UnsafeRow agg_fastAggBuffer = null;
/* 082 */
/* 083 */       if (agg_fastAggBuffer == null) {
/* 084 */         // generate grouping key
/* 085 */         agg_holder.reset();
/* 086 */
/* 087 */         agg_rowWriter.zeroOutNullBytes();
/* 088 */
/* 089 */         if (inputadapter_isNull) {
/* 090 */           agg_rowWriter.setNullAt(0);
/* 091 */         } else {
/* 092 */           agg_rowWriter.write(0, inputadapter_value);
/* 093 */         }
/* 094 */         agg_result.setTotalSize(agg_holder.totalSize());
/* 095 */         agg_value7 = 42;
/* 096 */
/* 097 */         if (!inputadapter_isNull) {
/* 098 */           agg_value7 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value.getBaseObject(), inputadapter_value.getBaseOffset(), inputadapter_value.numBytes(), agg_value7);
/* 099 */         }
/* 100 */         if (true) {
/* 101 */           // try to get the buffer from hash map
/* 102 */           agg_unsafeRowAggBuffer =
/* 103 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value7);
/* 104 */         }
/* 105 */         if (agg_unsafeRowAggBuffer == null) {
/* 106 */           if (agg_sorter == null) {
/* 107 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 108 */           } else {
/* 109 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 110 */           }
/* 111 */
/* 112 */           // the hash map had be spilled, it should have enough memory now,
/* 113 */           // try  to allocate buffer again.
/* 114 */           agg_unsafeRowAggBuffer =
/* 115 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value7);
/* 116 */           if (agg_unsafeRowAggBuffer == null) {
/* 117 */             // failed to allocate the first page
/* 118 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 119 */           }
/* 120 */         }
/* 121 */       }
/* 122 */
/* 123 */       if (agg_fastAggBuffer != null) {
/* 124 */         // update fast row
/* 125 */
/* 126 */       } else {
/* 127 */         // update unsafe row
/* 128 */
/* 129 */         // common sub-expressions
/* 130 */
/* 131 */         // evaluate aggregate function
/* 132 */         boolean agg_isNull7 = true;
/* 133 */         double agg_value9 = -1.0;
/* 134 */
/* 135 */         boolean agg_isNull8 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 136 */         double agg_value10 = agg_isNull8 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 137 */         if (!agg_isNull8) {
/* 138 */           if (!inputadapter_isNull1) {
/* 139 */             agg_isNull7 = false; // resultCode could change nullability.
/* 140 */             agg_value9 = agg_value10 + inputadapter_value1;
/* 141 */
/* 142 */           }
/* 143 */
/* 144 */         }
/* 145 */         boolean agg_isNull10 = true;
/* 146 */         long agg_value12 = -1L;
/* 147 */
/* 148 */         boolean agg_isNull11 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 149 */         long agg_value13 = agg_isNull11 ? -1L : (agg_unsafeRowAggBuffer.getLong(1));
/* 150 */         if (!agg_isNull11) {
/* 151 */           if (!inputadapter_isNull2) {
/* 152 */             agg_isNull10 = false; // resultCode could change nullability.
/* 153 */             agg_value12 = agg_value13 + inputadapter_value2;
/* 154 */
/* 155 */           }
/* 156 */
/* 157 */         }
/* 158 */         // update unsafe row buffer
/* 159 */         if (!agg_isNull7) {
/* 160 */           agg_unsafeRowAggBuffer.setDouble(0, agg_value9);
/* 161 */         } else {
/* 162 */           agg_unsafeRowAggBuffer.setNullAt(0);
/* 163 */         }
/* 164 */
/* 165 */         if (!agg_isNull10) {
/* 166 */           agg_unsafeRowAggBuffer.setLong(1, agg_value12);
/* 167 */         } else {
/* 168 */           agg_unsafeRowAggBuffer.setNullAt(1);
/* 169 */         }
/* 170 */
/* 171 */       }
/* 172 */       if (shouldStop()) return;
/* 173 */     }
/* 174 */
/* 175 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 176 */   }
/* 177 */
/* 178 */   private void wholestagecodegen_init_1() {
/* 179 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 2);
/* 180 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 181 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[5];
/* 182 */
/* 183 */   }
/* 184 */
/* 185 */   protected void processNext() throws java.io.IOException {
/* 186 */     if (!agg_initAgg) {
/* 187 */       agg_initAgg = true;
/* 188 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 189 */       agg_doAggregateWithKeys();
/* 190 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 191 */     }
/* 192 */
/* 193 */     // output the result
/* 194 */
/* 195 */     while (agg_mapIter.next()) {
/* 196 */       wholestagecodegen_numOutputRows.add(1);
/* 197 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 198 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 199 */
/* 200 */       boolean agg_isNull13 = agg_aggKey.isNullAt(0);
/* 201 */       UTF8String agg_value15 = agg_isNull13 ? null : (agg_aggKey.getUTF8String(0));
/* 202 */       boolean agg_isNull14 = agg_aggBuffer.isNullAt(0);
/* 203 */       double agg_value16 = agg_isNull14 ? -1.0 : (agg_aggBuffer.getDouble(0));
/* 204 */       boolean agg_isNull15 = agg_aggBuffer.isNullAt(1);
/* 205 */       long agg_value17 = agg_isNull15 ? -1L : (agg_aggBuffer.getLong(1));
/* 206 */       boolean agg_isNull18 = agg_isNull15;
/* 207 */       double agg_value20 = -1.0;
/* 208 */       if (!agg_isNull15) {
/* 209 */         agg_value20 = (double) agg_value17;
/* 210 */       }
/* 211 */       boolean agg_isNull16 = false;
/* 212 */       double agg_value18 = -1.0;
/* 213 */       if (agg_isNull18 || agg_value20 == 0) {
/* 214 */         agg_isNull16 = true;
/* 215 */       } else {
/* 216 */         if (agg_isNull14) {
/* 217 */           agg_isNull16 = true;
/* 218 */         } else {
/* 219 */           agg_value18 = (double)(agg_value16 / agg_value20);
/* 220 */         }
/* 221 */       }
/* 222 */
/* 223 */       if (!(!(agg_isNull16))) continue;
/* 224 */
/* 225 */       filter_numOutputRows.add(1);
/* 226 */
/* 227 */       filter_holder.reset();
/* 228 */
/* 229 */       filter_rowWriter.zeroOutNullBytes();
/* 230 */
/* 231 */       filter_rowWriter.write(0, agg_value18);
/* 232 */
/* 233 */       if (agg_isNull13) {
/* 234 */         filter_rowWriter.setNullAt(1);
/* 235 */       } else {
/* 236 */         filter_rowWriter.write(1, agg_value15);
/* 237 */       }
/* 238 */       filter_result.setTotalSize(filter_holder.totalSize());
/* 239 */       append(filter_result);
/* 240 */
/* 241 */       if (shouldStop()) return;
/* 242 */     }
/* 243 */
/* 244 */     agg_mapIter.close();
/* 245 */     if (agg_sorter == null) {
/* 246 */       agg_hashMap.free();
/* 247 */     }
/* 248 */   }
/* 249 */ }
