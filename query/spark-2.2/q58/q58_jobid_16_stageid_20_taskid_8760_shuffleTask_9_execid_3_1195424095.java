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
/* 021 */   private int agg_value4;
/* 022 */   private UnsafeRow agg_result1;
/* 023 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder1;
/* 024 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter1;
/* 025 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 026 */   private UnsafeRow filter_result;
/* 027 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 028 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 029 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 030 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 031 */
/* 032 */   public GeneratedIterator(Object[] references) {
/* 033 */     this.references = references;
/* 034 */   }
/* 035 */
/* 036 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 037 */     partitionIndex = index;
/* 038 */     this.inputs = inputs;
/* 039 */     wholestagecodegen_init_0();
/* 040 */     wholestagecodegen_init_1();
/* 041 */
/* 042 */   }
/* 043 */
/* 044 */   private void wholestagecodegen_init_0() {
/* 045 */     agg_initAgg = false;
/* 046 */
/* 047 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 048 */
/* 049 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 050 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 051 */     inputadapter_input = inputs[0];
/* 052 */     agg_result = new UnsafeRow(1);
/* 053 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result, 32);
/* 054 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 1);
/* 055 */
/* 056 */     agg_result1 = new UnsafeRow(2);
/* 057 */     this.agg_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 32);
/* 058 */     this.agg_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder1, 2);
/* 059 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[3];
/* 060 */     filter_result = new UnsafeRow(2);
/* 061 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 32);
/* 062 */
/* 063 */   }
/* 064 */
/* 065 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 066 */     agg_hashMap = agg_plan.createHashMap();
/* 067 */
/* 068 */     while (inputadapter_input.hasNext() && !stopEarly()) {
/* 069 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 070 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 071 */       UTF8String inputadapter_value = inputadapter_isNull ? null : (inputadapter_row.getUTF8String(0));
/* 072 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 073 */       double inputadapter_value1 = inputadapter_isNull1 ? -1.0 : (inputadapter_row.getDouble(1));
/* 074 */
/* 075 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 076 */
/* 077 */       UnsafeRow agg_fastAggBuffer = null;
/* 078 */
/* 079 */       if (agg_fastAggBuffer == null) {
/* 080 */         // generate grouping key
/* 081 */         agg_holder.reset();
/* 082 */
/* 083 */         agg_rowWriter.zeroOutNullBytes();
/* 084 */
/* 085 */         if (inputadapter_isNull) {
/* 086 */           agg_rowWriter.setNullAt(0);
/* 087 */         } else {
/* 088 */           agg_rowWriter.write(0, inputadapter_value);
/* 089 */         }
/* 090 */         agg_result.setTotalSize(agg_holder.totalSize());
/* 091 */         agg_value4 = 42;
/* 092 */
/* 093 */         if (!inputadapter_isNull) {
/* 094 */           agg_value4 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value.getBaseObject(), inputadapter_value.getBaseOffset(), inputadapter_value.numBytes(), agg_value4);
/* 095 */         }
/* 096 */         if (true) {
/* 097 */           // try to get the buffer from hash map
/* 098 */           agg_unsafeRowAggBuffer =
/* 099 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value4);
/* 100 */         }
/* 101 */         if (agg_unsafeRowAggBuffer == null) {
/* 102 */           if (agg_sorter == null) {
/* 103 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 104 */           } else {
/* 105 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 106 */           }
/* 107 */
/* 108 */           // the hash map had be spilled, it should have enough memory now,
/* 109 */           // try  to allocate buffer again.
/* 110 */           agg_unsafeRowAggBuffer =
/* 111 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value4);
/* 112 */           if (agg_unsafeRowAggBuffer == null) {
/* 113 */             // failed to allocate the first page
/* 114 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 115 */           }
/* 116 */         }
/* 117 */       }
/* 118 */
/* 119 */       if (agg_fastAggBuffer != null) {
/* 120 */         // update fast row
/* 121 */
/* 122 */       } else {
/* 123 */         // update unsafe row
/* 124 */
/* 125 */         // common sub-expressions
/* 126 */
/* 127 */         // evaluate aggregate function
/* 128 */         boolean agg_isNull6 = true;
/* 129 */         double agg_value7 = -1.0;
/* 130 */
/* 131 */         boolean agg_isNull8 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 132 */         double agg_value9 = agg_isNull8 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 133 */         boolean agg_isNull7 = agg_isNull8;
/* 134 */         double agg_value8 = agg_value9;
/* 135 */         if (agg_isNull7) {
/* 136 */           boolean agg_isNull9 = false;
/* 137 */           double agg_value10 = -1.0;
/* 138 */           if (!false) {
/* 139 */             agg_value10 = (double) 0;
/* 140 */           }
/* 141 */           if (!agg_isNull9) {
/* 142 */             agg_isNull7 = false;
/* 143 */             agg_value8 = agg_value10;
/* 144 */           }
/* 145 */         }
/* 146 */
/* 147 */         if (!inputadapter_isNull1) {
/* 148 */           agg_isNull6 = false; // resultCode could change nullability.
/* 149 */           agg_value7 = agg_value8 + inputadapter_value1;
/* 150 */
/* 151 */         }
/* 152 */         boolean agg_isNull5 = agg_isNull6;
/* 153 */         double agg_value6 = agg_value7;
/* 154 */         if (agg_isNull5) {
/* 155 */           boolean agg_isNull12 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 156 */           double agg_value13 = agg_isNull12 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 157 */           if (!agg_isNull12) {
/* 158 */             agg_isNull5 = false;
/* 159 */             agg_value6 = agg_value13;
/* 160 */           }
/* 161 */         }
/* 162 */         // update unsafe row buffer
/* 163 */         if (!agg_isNull5) {
/* 164 */           agg_unsafeRowAggBuffer.setDouble(0, agg_value6);
/* 165 */         } else {
/* 166 */           agg_unsafeRowAggBuffer.setNullAt(0);
/* 167 */         }
/* 168 */
/* 169 */       }
/* 170 */       if (shouldStop()) return;
/* 171 */     }
/* 172 */
/* 173 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 174 */   }
/* 175 */
/* 176 */   private void wholestagecodegen_init_1() {
/* 177 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 2);
/* 178 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 179 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[5];
/* 180 */
/* 181 */   }
/* 182 */
/* 183 */   protected void processNext() throws java.io.IOException {
/* 184 */     if (!agg_initAgg) {
/* 185 */       agg_initAgg = true;
/* 186 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 187 */       agg_doAggregateWithKeys();
/* 188 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 189 */     }
/* 190 */
/* 191 */     // output the result
/* 192 */
/* 193 */     while (agg_mapIter.next()) {
/* 194 */       wholestagecodegen_numOutputRows.add(1);
/* 195 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 196 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 197 */
/* 198 */       boolean agg_isNull13 = agg_aggKey.isNullAt(0);
/* 199 */       UTF8String agg_value14 = agg_isNull13 ? null : (agg_aggKey.getUTF8String(0));
/* 200 */       boolean agg_isNull14 = agg_aggBuffer.isNullAt(0);
/* 201 */       double agg_value15 = agg_isNull14 ? -1.0 : (agg_aggBuffer.getDouble(0));
/* 202 */
/* 203 */       if (!(!(agg_isNull14))) continue;
/* 204 */
/* 205 */       filter_numOutputRows.add(1);
/* 206 */
/* 207 */       filter_holder.reset();
/* 208 */
/* 209 */       filter_rowWriter.zeroOutNullBytes();
/* 210 */
/* 211 */       if (agg_isNull13) {
/* 212 */         filter_rowWriter.setNullAt(0);
/* 213 */       } else {
/* 214 */         filter_rowWriter.write(0, agg_value14);
/* 215 */       }
/* 216 */
/* 217 */       filter_rowWriter.write(1, agg_value15);
/* 218 */       filter_result.setTotalSize(filter_holder.totalSize());
/* 219 */       append(filter_result);
/* 220 */
/* 221 */       if (shouldStop()) return;
/* 222 */     }
/* 223 */
/* 224 */     agg_mapIter.close();
/* 225 */     if (agg_sorter == null) {
/* 226 */       agg_hashMap.free();
/* 227 */     }
/* 228 */   }
/* 229 */ }
