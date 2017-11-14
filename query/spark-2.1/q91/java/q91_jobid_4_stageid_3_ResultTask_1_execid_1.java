/* 001 */ public Object generate(Object[] references) {
/* 002 */   return new GeneratedIterator(references);
/* 003 */ }
/* 004 */
/* 005 */ final class GeneratedIterator extends org.apache.spark.sql.execution.BufferedRowIterator {
/* 006 */   private Object[] references;
/* 007 */   private scala.collection.Iterator[] inputs;
/* 008 */   private scala.collection.Iterator scan_input;
/* 009 */   private org.apache.spark.sql.execution.metric.SQLMetric scan_numOutputRows;
/* 010 */   private org.apache.spark.sql.execution.metric.SQLMetric scan_scanTime;
/* 011 */   private long scan_scanTime1;
/* 012 */   private org.apache.spark.sql.execution.vectorized.ColumnarBatch scan_batch;
/* 013 */   private int scan_batchIdx;
/* 014 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance0;
/* 015 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance1;
/* 016 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance2;
/* 017 */   private UnsafeRow scan_result;
/* 018 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder scan_holder;
/* 019 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter scan_rowWriter;
/* 020 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 021 */   private UnsafeRow filter_result;
/* 022 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 023 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 024 */   private UnsafeRow project_result;
/* 025 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 026 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 027 */
/* 028 */   public GeneratedIterator(Object[] references) {
/* 029 */     this.references = references;
/* 030 */   }
/* 031 */
/* 032 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 033 */     partitionIndex = index;
/* 034 */     this.inputs = inputs;
/* 035 */     wholestagecodegen_init_0();
/* 036 */     wholestagecodegen_init_1();
/* 037 */
/* 038 */   }
/* 039 */
/* 040 */   private void wholestagecodegen_init_0() {
/* 041 */     scan_input = inputs[0];
/* 042 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 043 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 044 */     scan_scanTime1 = 0;
/* 045 */     scan_batch = null;
/* 046 */     scan_batchIdx = 0;
/* 047 */     scan_colInstance0 = null;
/* 048 */     scan_colInstance1 = null;
/* 049 */     scan_colInstance2 = null;
/* 050 */     scan_result = new UnsafeRow(3);
/* 051 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 64);
/* 052 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 3);
/* 053 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 054 */     filter_result = new UnsafeRow(3);
/* 055 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 64);
/* 056 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 3);
/* 057 */     project_result = new UnsafeRow(3);
/* 058 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 64);
/* 059 */
/* 060 */   }
/* 061 */
/* 062 */   private void scan_nextBatch() throws java.io.IOException {
/* 063 */     long getBatchStart = System.nanoTime();
/* 064 */     if (scan_input.hasNext()) {
/* 065 */       scan_batch = (org.apache.spark.sql.execution.vectorized.ColumnarBatch)scan_input.next();
/* 066 */       scan_numOutputRows.add(scan_batch.numRows());
/* 067 */       scan_batchIdx = 0;
/* 068 */       scan_colInstance0 = scan_batch.column(0);
/* 069 */       scan_colInstance1 = scan_batch.column(1);
/* 070 */       scan_colInstance2 = scan_batch.column(2);
/* 071 */
/* 072 */     }
/* 073 */     scan_scanTime1 += System.nanoTime() - getBatchStart;
/* 074 */   }
/* 075 */
/* 076 */   private void wholestagecodegen_init_1() {
/* 077 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 3);
/* 078 */
/* 079 */   }
/* 080 */
/* 081 */   protected void processNext() throws java.io.IOException {
/* 082 */     if (scan_batch == null) {
/* 083 */       scan_nextBatch();
/* 084 */     }
/* 085 */     while (scan_batch != null) {
/* 086 */       int numRows = scan_batch.numRows();
/* 087 */       while (scan_batchIdx < numRows) {
/* 088 */         int scan_rowIdx = scan_batchIdx++;
/* 089 */         boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 090 */         UTF8String scan_value1 = scan_isNull1 ? null : (scan_colInstance1.getUTF8String(scan_rowIdx));
/* 091 */         boolean scan_isNull2 = scan_colInstance2.isNullAt(scan_rowIdx);
/* 092 */         UTF8String scan_value2 = scan_isNull2 ? null : (scan_colInstance2.getUTF8String(scan_rowIdx));
/* 093 */
/* 094 */         boolean filter_isNull2 = true;
/* 095 */         boolean filter_value2 = false;
/* 096 */
/* 097 */         if (!scan_isNull1) {
/* 098 */           Object filter_obj = ((Expression) references[3]).eval(null);
/* 099 */           UTF8String filter_value4 = (UTF8String) filter_obj;
/* 100 */
/* 101 */           filter_isNull2 = false; // resultCode could change nullability.
/* 102 */           filter_value2 = scan_value1.equals(filter_value4);
/* 103 */
/* 104 */         }
/* 105 */         boolean filter_isNull1 = false;
/* 106 */         boolean filter_value1 = false;
/* 107 */
/* 108 */         if (!filter_isNull2 && !filter_value2) {
/* 109 */         } else {
/* 110 */           boolean filter_isNull5 = true;
/* 111 */           boolean filter_value5 = false;
/* 112 */
/* 113 */           if (!scan_isNull2) {
/* 114 */             Object filter_obj1 = ((Expression) references[4]).eval(null);
/* 115 */             UTF8String filter_value7 = (UTF8String) filter_obj1;
/* 116 */
/* 117 */             filter_isNull5 = false; // resultCode could change nullability.
/* 118 */             filter_value5 = scan_value2.equals(filter_value7);
/* 119 */
/* 120 */           }
/* 121 */           if (!filter_isNull5 && !filter_value5) {
/* 122 */           } else if (!filter_isNull2 && !filter_isNull5) {
/* 123 */             filter_value1 = true;
/* 124 */           } else {
/* 125 */             filter_isNull1 = true;
/* 126 */           }
/* 127 */         }
/* 128 */         boolean filter_isNull = false;
/* 129 */         boolean filter_value = true;
/* 130 */
/* 131 */         if (!filter_isNull1 && filter_value1) {
/* 132 */         } else {
/* 133 */           boolean filter_isNull9 = true;
/* 134 */           boolean filter_value9 = false;
/* 135 */
/* 136 */           if (!scan_isNull1) {
/* 137 */             Object filter_obj2 = ((Expression) references[5]).eval(null);
/* 138 */             UTF8String filter_value11 = (UTF8String) filter_obj2;
/* 139 */
/* 140 */             filter_isNull9 = false; // resultCode could change nullability.
/* 141 */             filter_value9 = scan_value1.equals(filter_value11);
/* 142 */
/* 143 */           }
/* 144 */           boolean filter_isNull8 = false;
/* 145 */           boolean filter_value8 = false;
/* 146 */
/* 147 */           if (!filter_isNull9 && !filter_value9) {
/* 148 */           } else {
/* 149 */             boolean filter_isNull12 = true;
/* 150 */             boolean filter_value12 = false;
/* 151 */
/* 152 */             if (!scan_isNull2) {
/* 153 */               Object filter_obj3 = ((Expression) references[6]).eval(null);
/* 154 */               UTF8String filter_value14 = (UTF8String) filter_obj3;
/* 155 */
/* 156 */               filter_isNull12 = false; // resultCode could change nullability.
/* 157 */               filter_value12 = scan_value2.equals(filter_value14);
/* 158 */
/* 159 */             }
/* 160 */             if (!filter_isNull12 && !filter_value12) {
/* 161 */             } else if (!filter_isNull9 && !filter_isNull12) {
/* 162 */               filter_value8 = true;
/* 163 */             } else {
/* 164 */               filter_isNull8 = true;
/* 165 */             }
/* 166 */           }
/* 167 */           if (!filter_isNull8 && filter_value8) {
/* 168 */           } else if (!filter_isNull1 && !filter_isNull8) {
/* 169 */             filter_value = false;
/* 170 */           } else {
/* 171 */             filter_isNull = true;
/* 172 */           }
/* 173 */         }
/* 174 */         if (filter_isNull || !filter_value) continue;
/* 175 */
/* 176 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 177 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 178 */
/* 179 */         if (!(!(scan_isNull))) continue;
/* 180 */
/* 181 */         filter_numOutputRows.add(1);
/* 182 */
/* 183 */         project_holder.reset();
/* 184 */
/* 185 */         project_rowWriter.zeroOutNullBytes();
/* 186 */
/* 187 */         project_rowWriter.write(0, scan_value);
/* 188 */
/* 189 */         if (scan_isNull1) {
/* 190 */           project_rowWriter.setNullAt(1);
/* 191 */         } else {
/* 192 */           project_rowWriter.write(1, scan_value1);
/* 193 */         }
/* 194 */
/* 195 */         if (scan_isNull2) {
/* 196 */           project_rowWriter.setNullAt(2);
/* 197 */         } else {
/* 198 */           project_rowWriter.write(2, scan_value2);
/* 199 */         }
/* 200 */         project_result.setTotalSize(project_holder.totalSize());
/* 201 */         append(project_result);
/* 202 */         if (shouldStop()) return;
/* 203 */       }
/* 204 */       scan_batch = null;
/* 205 */       scan_nextBatch();
/* 206 */     }
/* 207 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 208 */     scan_scanTime1 = 0;
/* 209 */   }
/* 210 */ }
